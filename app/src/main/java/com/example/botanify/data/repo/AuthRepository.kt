package com.example.botanify.data.repo

import android.util.Log
import com.example.botanify.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
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
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    suspend fun signup( email: String, password: String,name: String): Resource<FirebaseUser> {

        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            authResult.user?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(name).build()
            )
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
}