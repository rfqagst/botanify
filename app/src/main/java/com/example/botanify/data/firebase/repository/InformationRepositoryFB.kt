package com.example.botanify.data.firebase.repository

import android.util.Log
import com.example.botanify.data.model.Information
import com.example.botanify.utils.Resource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


class InformationRepositoryFB(
    firebaseDatabase: FirebaseDatabase,
) {

    private val informationRef = firebaseDatabase.getReference("informations")

    fun fetchInformationsFirebase(category: String?): Flow<Resource<List<Information>>> {
        val informationsFlow = MutableStateFlow<Resource<List<Information>>>(Resource.Loading(null))

        val query: Query = if (category != null && category != "Semua") {
            informationRef.orderByChild("kategori").equalTo(category)
        } else {
            informationRef
        }

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val informationsList = mutableListOf<Information>()
                for (snapshot in dataSnapshot.children) {
                    val information = snapshot.getValue(Information::class.java)
                    information?.let { informationsList.add(it) }
                }
                informationsFlow.value = Resource.Success(informationsList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                informationsFlow.value = Resource.Error(databaseError.message, null)
                Log.w("Databasedd", "loadPost:onCancelled", databaseError.toException())
            }
        })

        return informationsFlow
    }

    fun fetchInformationByIdFirebase(informationId: String): Flow<Resource<Information>> {
        val informationsFlow = MutableStateFlow<Resource<Information>>(Resource.Loading(null))

        informationRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val information = snapshot.getValue(Information::class.java)
                    if (information?.id == informationId) {
                        informationsFlow.value = Resource.Success(information)
                        Log.d(
                            "InformationRepositoryFB",
                            "Found Information with ID: $informationId"
                        )
                        return
                    }
                }
                informationsFlow.value = Resource.Error("Information not found", null)
                Log.d("InformationRepositoryFB", "Information not found for ID: $informationId")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                informationsFlow.value = Resource.Error(databaseError.message, null)
                Log.w(
                    "InformationRepositoryFB",
                    "fetchInformationById:onCancelled",
                    databaseError.toException()
                )
            }
        })

        return informationsFlow
    }
}


