package com.example.botanify.data.repo

import android.util.Log
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.data.model.User
import com.example.botanify.utils.Resource
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.database
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val firebaseAuth: FirebaseAuth
) {

    val currentUser = firebaseAuth.currentUser
    suspend fun login(email: String, password: String): Resource<FirebaseUser> {

        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(authResult.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("AuthRepositoryLogin", "$email,login: ${e.message}")
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    suspend fun signup( email: String, password: String, name: String): Resource<FirebaseUser> {

        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            authResult.user?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(name).build()
            )
            val user = authResult.user!!
            addUserToDatabase(user, name)
            Resource.Success(authResult.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("AuthRepository", "$email,signup: ${e.message}")

            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    fun logout() {
        firebaseAuth.signOut()
    }



    private suspend fun addUserToDatabase(user: FirebaseUser, name: String) {
        val database = Firebase.database
        val userRef = database.getReference("users").child(user.uid)
        val newUser = User(
            id = user.uid,
            name = name,
            email = user.email ?: ""
        )
        userRef.setValue(newUser).await()
    }

    suspend fun addPlantCollectionToUser(userId: String, plantCollection: PlantCollection): Resource<Boolean> {
        return try {
            val database = Firebase.database
            val userRef = database.getReference("users").child(userId)
            val plantCollectionId = userRef.child("plantCollections").push().key ?: throw Exception("Cannot generate a new plant collection ID")
            userRef.child("plantCollections").child(plantCollectionId).setValue(plantCollection).await()
            Resource.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("AuthRepository", "addPlantCollectionToUser: ${e.message}")
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

}