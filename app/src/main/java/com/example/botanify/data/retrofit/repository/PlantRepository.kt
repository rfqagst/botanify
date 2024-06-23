package com.example.botanify.data.retrofit.repository

import android.util.Log
import com.example.botanify.data.retrofit.response.backend.DataItem
import com.example.botanify.data.retrofit.response.backend.DataItemCollection
import com.example.botanify.data.retrofit.response.backend.HamaResponseItem
import com.example.botanify.data.retrofit.response.backend.PenyakitResponseItem
import com.example.botanify.data.retrofit.response.backend.PlantDetailResponse
import com.example.botanify.data.retrofit.response.backend.PlantResponse
import com.example.botanify.data.retrofit.response.backend.ResponseCollection
import com.example.botanify.data.retrofit.services.PlantServices
import com.example.botanify.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class PlantRepository @Inject constructor(
    private val plantServices: PlantServices
) {
    suspend fun getPlants(): Flow<Resource<List<DataItem>>> = flow {
        emit(Resource.Loading())
        try {
            val response = plantServices.fetchPlants()
            if (response.isSuccessful) {
                response.body()?.data?.let { plants ->
                    Log.d("PlantRepository", "Fetched plants: $plants")
                    emit(Resource.Success(plants.filterNotNull()))
                } ?: emit(Resource.Error("No plants found"))
            } else {
                emit(Resource.Error("Error fetching plants: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun getPlantById(id: String): Flow<Resource<PlantDetailResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = plantServices.fetchPlantById(id)
            if (response.isSuccessful) {
                val plantResponse = response.body()
                plantResponse?.let { plant ->
                    Log.d("PlantRepositorygetPlantById", "Fetched plant: $plant")
                    emit(Resource.Success(plant))
                } ?: emit(Resource.Error("No plant found"))
            } else {
                emit(Resource.Error("Error fetching plants: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun getPlantByName(name: String): Resource<PlantDetailResponse> {
        return try {
            val response = plantServices.fetchPlantByName(name)
            if (response.isSuccessful) {
                response.body()?.let { plantResponse ->
                    Log.d("PlantRepositorygetPlantByName", "Fetched plant: $plantResponse")
                    Resource.Success(plantResponse)
                } ?: Resource.Error("No plant found")
            } else {
                Resource.Error("Error fetching plant: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("PlantRepositorygetPlantByName", "Error fetching plant by name : ${e.message}")
            Resource.Error("Exception: ${e.message}")

        }
    }


    suspend fun getUserCollections(userId : String): Flow<Resource<List<DataItemCollection>>> = flow {
        emit(Resource.Loading())
        try {
            val response = plantServices.fetchUserPlantCollection(userId)
            if (response.isSuccessful) {
                response.body()?.data?.let { collections ->
                    Log.d("PlantRepository", "Fetched collections: $collections")
                    emit(Resource.Success(collections.filterNotNull()))
                } ?: emit(Resource.Error("No Collection found"))
            } else {
                emit(Resource.Error("Error fetching collections: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)



}