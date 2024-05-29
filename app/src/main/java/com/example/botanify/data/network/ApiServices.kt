package com.example.botanify.data.network

import retrofit2.http.GET

interface ApiServices {
    @GET
    suspend fun fetchPlant()
}