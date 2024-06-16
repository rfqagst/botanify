package com.example.botanify.data.retrofit.repository

import android.util.Log
import com.example.botanify.data.retrofit.response.backend.DetailInformationItem
import com.example.botanify.data.retrofit.response.backend.InformationDetailResponse
import com.example.botanify.data.retrofit.response.backend.InformationsResponseItem
import com.example.botanify.data.retrofit.services.InformationServices
import com.example.botanify.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InformationRepository @Inject constructor(
    private val informationServices: InformationServices
) {

    suspend fun getInformations(): Flow<Resource<List<InformationsResponseItem>>> = flow {
        emit(Resource.Loading())
        try {
            val response = informationServices.fetchInformationArticles()
            if (response.isSuccessful) {
                response.body()?.let { informations ->
                    Log.d("InformationRepository", "Fetched plants: $informations")
                    emit(Resource.Success(informations))
                } ?: emit(Resource.Error("No plants found"))
            } else {
                emit(Resource.Error("Error fetching plants: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun getInformationsByCategory(category: String): Flow<Resource<List<InformationsResponseItem>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = informationServices.fetchInformationArticlesByCategory(category)
                if (response.isSuccessful) {
                    response.body()?.let { informations ->
                        Log.d("InformationCategoryRepository", "Fetched plants: $informations")
                        emit(Resource.Success(informations))
                    } ?: emit(Resource.Error("No plants found"))
                } else {
                    emit(Resource.Error("Error fetching plants: ${response.message()}"))
                }
            } catch (e: Exception) {
                emit(Resource.Error("Exception: ${e.message}"))
            }
        }.flowOn(Dispatchers.IO)


    suspend fun getInformationsById(id: String): Flow<Resource<InformationDetailResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = informationServices.fetchInformationArticleById(id)
            if (response.isSuccessful) {
                response.body()?.let { informations ->
                    Log.d("InformationCategoryRepository", "Fetched plants: $informations")
                    emit(Resource.Success(informations))
                } ?: emit(Resource.Error("No plants found"))
            } else {
                emit(Resource.Error("Error fetching plants: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Exception: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)


}