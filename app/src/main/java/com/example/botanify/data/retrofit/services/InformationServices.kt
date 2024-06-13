package com.example.botanify.data.retrofit.services

import com.example.botanify.data.retrofit.response.backend.InformationResponse
import com.example.botanify.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface InformationServices {
    @GET("informasi")
    suspend fun fetchInformationArticles(
    ): Flow<Resource<List<InformationResponse>>>

    @GET("informasi/{kategori}")
    suspend fun fetchInformationArticlesByCategory(
        @Path("kategori") kategori: String
    ): Flow<Resource<List<InformationResponse>>>

    @GET("informasi/{id}")
    suspend fun fetchInformationArticleById(
        @Path("id") id: String
    ): InformationResponse

}