package com.example.botanify.data.retrofit.services

import com.example.botanify.data.retrofit.response.scan.PredictionsResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ClassifyPlantDiseasesServices {
    @Multipart
    @POST("botanify-hama/5")
    suspend fun classifyPlantDiseasesPests(
        @Query("api_key") apiKey: String,
        @Part file: MultipartBody.Part
    ): PredictionsResponse

}