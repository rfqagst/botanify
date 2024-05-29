package com.example.botanify.data.retrofit

import com.example.botanify.data.model.Information
import com.example.botanify.data.model.Plant
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiServices {
    @GET
    suspend fun fetchPlant(): Flow<Resource<List<Plant>>>

    @GET
    suspend fun fetchUserPlantCollection(userId: String): Flow<Resource<List<PlantCollection>>>

    @GET
    suspend fun fetchInformationArticle(): Flow<Resource<List<Information>>>

    @GET
    suspend fun fetchInformationArticleById(): Flow<Resource<List<Information>>>

    @GET
    suspend fun fetchPlantById(plantId: String): Flow<Resource<Plant>>

    @POST
    suspend fun addPlantCollection(
        userId: String,
        plantCollection: PlantCollection
    ): Flow<Resource<PlantCollection>>


    @DELETE
    suspend fun deletePlantCollection(
        userId: String,
        plantCollection: PlantCollection
    ): Flow<Resource<PlantCollection>>



}