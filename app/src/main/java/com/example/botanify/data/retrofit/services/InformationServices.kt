package com.example.botanify.data.retrofit.services

import com.example.botanify.data.retrofit.response.backend.DetailInformationItem
import com.example.botanify.data.retrofit.response.backend.InformationDetailResponse
import com.example.botanify.data.retrofit.response.backend.InformationsResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InformationServices {
    @GET("informasi")
    suspend fun fetchInformationArticles(
    ): Response<List<InformationsResponseItem>>

    @GET("informasi/{kategori}")
    suspend fun fetchInformationArticlesByCategory(
        @Path("kategori") kategori: String
    ): Response<List<InformationsResponseItem>>

    @GET("informasi/{id}")
    suspend fun fetchInformationArticleById(
        @Path("id") id: String
    ): Response<InformationDetailResponse>

}