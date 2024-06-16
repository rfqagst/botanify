package com.example.botanify.data.retrofit.services

import com.example.botanify.data.retrofit.response.backend.HamaResponseItem
import com.example.botanify.data.retrofit.response.backend.PenyakitResponse
import com.example.botanify.data.retrofit.response.backend.PenyakitResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PenanggananServices {
    @GET("penanganan/penyakit/{namaPenyakit}")
   suspend fun getPenyakit(@Path("namaPenyakit") namaPenyakit: String): Response<List<PenyakitResponseItem>>


    @GET("penanganan/hama/{namaHama}")
    suspend fun getHama(@Path("namaHama") namaHama: String): Response<List<HamaResponseItem>>
}