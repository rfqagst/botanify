package com.example.botanify.data.retrofit.services

import com.example.botanify.data.firebase.model.PlantCollection
import com.example.botanify.data.retrofit.response.backend.DataItemCollection
import com.example.botanify.data.retrofit.response.backend.PlantDetailResponse
import com.example.botanify.data.retrofit.response.backend.PlantResponse
import com.example.botanify.data.retrofit.response.backend.ResponseCollection
import com.example.botanify.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PlantServices {
    @GET("tanaman")
    suspend fun fetchPlants(): Response<PlantResponse>

    @GET("tanaman/name/{name}")
    suspend fun fetchPlantByName(
        @Path("name") name: String
    ): Response<PlantDetailResponse>

    @GET("tanaman/{id}")
    suspend fun fetchPlantById(@Path("id") id: String): Response<PlantDetailResponse>


    @GET("koleksi/user/{userId}")
    suspend fun fetchUserPlantCollection(userId: String): Response<ResponseCollection>

    @POST
    suspend fun addPlantCollection(
        userId: String,
        plantCollection: PlantCollection
    ): Resource<PlantCollection>


    @DELETE
    suspend fun deletePlantCollection(
        userId: String,
        plantCollection: PlantCollection
    ): Resource<PlantCollection>


}