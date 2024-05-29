package com.example.botanify.data.repo

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.example.botanify.data.model.Plant
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.utils.Resource
import com.example.botanify.utils.uriToBitmap
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await
import java.io.ByteArrayOutputStream
import java.util.UUID
import javax.inject.Inject

class PlantRepository (
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
    private val firebaseStorage: FirebaseStorage
    ) {

    private val plantRef = firebaseDatabase.getReference("plants")

    val currentUser = firebaseAuth.currentUser

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

    fun fetchPlantById(plantId: String): Flow<Resource<Plant>> {
        val plantFlow = MutableStateFlow<Resource<Plant>>(Resource.Loading(null))

        plantRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val plant = snapshot.getValue(Plant::class.java)
                    if (plant?.id == plantId) {
                        plantFlow.value = Resource.Success(plant)
                        Log.d("PlantRepository", "Found plant with ID: $plantId")
                        return
                    }
                }
                plantFlow.value = Resource.Error("Plant not found", null)
                Log.d("PlantRepository", "Plant not found for ID: $plantId")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                plantFlow.value = Resource.Error(databaseError.message, null)
                Log.w("PlantRepository", "fetchPlantById:onCancelled", databaseError.toException())
            }
        })

        return plantFlow
    }


    suspend fun addPlantCollectionToUser(
        userId: String,
        plantCollection: PlantCollection
    ): Resource<Boolean> {
        return try {
            val userRef = firebaseDatabase.getReference("users").child(userId)
            val plantCollectionId = userRef.child("plantCollections").push().key ?: throw Exception(
                "Cannot generate a new plant collection ID"
            )
            userRef.child("plantCollections").child(plantCollectionId).setValue(plantCollection)
                .await()
            Resource.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("AuthRepository", "addPlantCollectionToUser: ${e.message}")
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }


    fun fetchKoleksiTanaman(userId: String): Flow<Resource<List<PlantCollection>>> {
        val plantCollectionFlow =
            MutableStateFlow<Resource<List<PlantCollection>>>(Resource.Loading(null))
        val collectionRef = plantRef.child(userId).child("plantCollections")

        collectionRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val plantCollections = mutableListOf<PlantCollection>()
                for (child in snapshot.children) {
                    val plantCollection = child.getValue(PlantCollection::class.java)
                    plantCollection?.let { plantCollections.add(it) }
                }
                plantCollectionFlow.value = Resource.Success(plantCollections)
            }

            override fun onCancelled(error: DatabaseError) {
                plantCollectionFlow.value = Resource.Error(error.message, null)
                Log.w("PlantRepository", "fetchKoleksiTanaman:onCancelled", error.toException())
            }

        })
        return plantCollectionFlow

    }


    fun uploadImageToFirebaseStorage(uri: Uri, context: Context, onSuccess: (String) -> Unit) {
        val storageRef = firebaseStorage.reference.child("userupload/${UUID.randomUUID()}.jpg")
        val bitmap = uriToBitmap(uri, context)
        val baos = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val uploadTask = storageRef.putBytes(data)
        uploadTask.addOnSuccessListener {
            storageRef.downloadUrl.addOnSuccessListener { uri ->
                onSuccess(uri.toString())
            }
        }.addOnFailureListener {
            it.printStackTrace()
            // Handle any errors
        }
    }
}