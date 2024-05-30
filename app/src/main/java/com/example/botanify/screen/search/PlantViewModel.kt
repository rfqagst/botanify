package com.example.botanify.screen.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.model.Plant
import com.example.botanify.data.firebase.repository.PlantRepository
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

    private val _plants = MutableStateFlow<Resource<List<Plant>>>(Resource.Loading(null))
    val plants: StateFlow<Resource<List<Plant>>> = _plants


    private val _plantsById = MutableStateFlow<Resource<Plant>>(Resource.Loading(null))
    val plantsById: StateFlow<Resource<Plant>> = _plantsById

    init {
        fetchPlants()
    }

    private fun fetchPlants() {
        viewModelScope.launch {
            plantRepository.fetchPlantsFirebase().collect { plantsData ->
                _plants.value = plantsData
                Log.d("plantssssssssss", plantsData.toString())
            }
        }
    }


    fun fetchPlantById(plantId: String) {
        viewModelScope.launch {
            Log.d("PlantViewModel", "Fetching plant with ID: $plantId")
            plantRepository.fetchPlantByIdFirebase(plantId).collect { plantData ->
                _plantsById.value = plantData
                Log.d("PlantViewModel", "Plant data fetched: $plantData")
            }
        }
    }
}