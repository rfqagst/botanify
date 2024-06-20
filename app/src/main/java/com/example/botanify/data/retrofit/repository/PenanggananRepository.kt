package com.example.botanify.data.retrofit.repository

import android.util.Log
import com.example.botanify.data.retrofit.response.backend.HamaResponseItem
import com.example.botanify.data.retrofit.response.backend.PenyakitResponseItem
import com.example.botanify.data.retrofit.services.PenanggananServices
import javax.inject.Inject

class PenanggananRepository @Inject constructor(
    private val penanggananServices: PenanggananServices
) {

    suspend fun getPenanggananPenyakit(namaPenyakit: String): List<PenyakitResponseItem> {
        return try {
            val response = penanggananServices.getPenyakit(namaPenyakit)
            Log.d("PenanggananRepository", namaPenyakit)
            Log.d("PenanggananRepository", response.body().toString())
            response.body() ?: emptyList()

        } catch (e: Exception) {
            Log.e("Error", e.localizedMessage ?: "Error")
            emptyList()
        }
    }


    suspend fun getPenanggananHama(namaHama: String): List<HamaResponseItem> {
        return try {
            val response = penanggananServices.getHama(namaHama)
            response.body() ?: emptyList()

        } catch (e: Exception) {
            Log.e("Error", e.localizedMessage ?: "Error")
            emptyList()
        }
    }
}