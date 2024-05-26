package com.example.botanify.data.repo

import android.util.Log
import com.example.botanify.data.model.Plant
import com.example.botanify.utils.Resource
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class PlantRepository() {

    private val database = Firebase.database
    private val plantRef = database.getReference("plants")

    fun fetchPlants(): Flow<Resource<List<Plant>>> {
        val plantsFlow = MutableStateFlow<Resource<List<Plant>>>(Resource.Loading(null))

        plantRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val plantsList = mutableListOf<Plant>()
                for (snapshot in dataSnapshot.children) {
                    val plant = snapshot.getValue(Plant::class.java)
                    plant?.let { plantsList.add(it) }
                }
                plantsFlow.value = Resource.Success(plantsList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                plantsFlow.value = Resource.Error(databaseError.message, null)
                Log.w("Databasedd", "loadPost:onCancelled", databaseError.toException())
            }
        })

        return plantsFlow
    }

}