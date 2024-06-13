package com.example.botanify.data.firebase.repository

import android.util.Log
import com.example.botanify.data.firebase.model.User
import com.example.botanify.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase
) {

    val currentUserFirebase = firebaseAuth.currentUser
    suspend fun loginFirebase(email: String, password: String): Resource<FirebaseUser> {

        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(authResult.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("AuthRepositoryLogin", "$email,login: ${e.message}")
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    suspend fun signupFirebase(email: String, password: String, name: String): Resource<FirebaseUser> {

        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            authResult.user?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(name).build()
            )
            val user = authResult.user!!
            addUserToDatabaseFirebase(user, name)
            Resource.Success(authResult.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("AuthRepository", "$email,signup: ${e.message}")

            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    fun logoutFirebase() {
        firebaseAuth.signOut()
    }


    private suspend fun addUserToDatabaseFirebase(user: FirebaseUser, name: String) {
        val userRef = firebaseDatabase.getReference("users").child(user.uid)
        val newUser = User(
            id = user.uid,
            name = name,
            email = user.email ?: ""
        )
        userRef.setValue(newUser).await()
    }

}