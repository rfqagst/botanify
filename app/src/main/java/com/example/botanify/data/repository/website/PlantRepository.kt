package com.example.botanify.data.repository.website

import com.example.botanify.data.network.ApiServices
import javax.inject.Inject

class PlantRepository @Inject constructor(
    private val apiServices: ApiServices
) {
    suspend fun getPlants() = apiServices.fetchPlant()

}