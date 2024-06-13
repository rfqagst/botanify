package com.example.botanify.data.retrofit.repository

import com.example.botanify.data.retrofit.services.UserServices
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userServices: UserServices
) {

}