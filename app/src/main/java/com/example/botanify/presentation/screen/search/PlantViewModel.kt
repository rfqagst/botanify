package com.example.botanify.presentation.screen.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.botanify.data.retrofit.repository.PlantRepository
import com.example.botanify.data.retrofit.response.backend.DataItem
import com.example.botanify.data.retrofit.response.backend.PlantDetailResponse
import com.example.botanify.data.retrofit.response.backend.PlantResponse
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantViewModel @Inject constructor(
    private val plantRepository: PlantRepository
) : ViewModel() {


    private val _plants = MutableStateFlow<Resource<List<DataItem>>>(Resource.Loading())
    val plants: StateFlow<Resource<List<DataItem>>> = _plants


    private val _plantsById = MutableStateFlow<Resource<PlantDetailResponse>>(Resource.Loading())
    val plantsById: StateFlow<Resource<PlantDetailResponse>> = _plantsById




    init {
        fetchPlants()
    }

    private fun fetchPlants() {
        viewModelScope.launch {
            plantRepository.getPlants().collect { plantsData ->
                _plants.value = plantsData
                Log.d("PlantViewModel", plantsData.toString())
            }
        }
    }


    fun fetchPlantById(plantId: String) {
        viewModelScope.launch {
            Log.d("PlantViewModel", "Fetching plant with ID: $plantId")
            plantRepository.getPlantById(plantId).collect { plantData ->
                _plantsById.value = plantData

                Log.d("PlantViewModel", "Plant data fetched: ${plantData.data}")
            }
        }
    }


}