package com.example.botanify.data.retrofit.repository

import com.example.botanify.data.retrofit.response.backend.HamaResponseItem
import com.example.botanify.data.retrofit.response.backend.PenyakitResponseItem
import com.example.botanify.data.retrofit.services.PenanggananServices
import com.example.botanify.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PenanggananRepository @Inject constructor(
    private val penanggananServices: PenanggananServices
) {
    suspend fun getPenanggananPenyakit(namaPenyakit: String): Flow<Resource<List<PenyakitResponseItem>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = penanggananServices.getPenyakit(namaPenyakit)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it))
                    }
                } else {
                    emit(Resource.Error(response.message()))
                }

            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Error"))
            }
        }


    suspend fun getPenanggananHama(namaHama: String): Flow<Resource<List<HamaResponseItem>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = penanggananServices.getHama(namaHama)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it))
                    }
                } else {
                    emit(Resource.Error(response.message()))
                }

            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Error"))
            }
        }
}