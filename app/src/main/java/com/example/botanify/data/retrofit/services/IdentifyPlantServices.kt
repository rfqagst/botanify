package com.example.botanify.data.retrofit.services

import com.example.botanify.data.retrofit.response.scan.ScanPlantResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface IdentifyPlantServices {
    @Multipart
    @POST("result")
    suspend fun identifyPlantName(
        @Part file: MultipartBody.Part
    ): ScanPlantResponse



}