package com.example.botanify.data.retrofit.services

import com.example.botanify.data.firebase.model.User
import com.example.botanify.data.retrofit.repository.UserRepository
import com.example.botanify.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.POST
import javax.inject.Inject

interface UserServices {
    @POST
    suspend fun addUserToDatabase(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<User>>

}