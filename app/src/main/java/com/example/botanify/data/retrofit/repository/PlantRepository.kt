package com.example.botanify.data.retrofit.repository

import com.example.botanify.data.retrofit.ApiServices
import javax.inject.Inject

class PlantRepository @Inject constructor(
    private val apiServices: ApiServices
) {
    suspend fun getPlants() = apiServices.fetchPlant()

}