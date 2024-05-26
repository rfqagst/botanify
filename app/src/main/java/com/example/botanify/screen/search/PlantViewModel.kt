package com.example.botanify.screen.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.model.Plant
import com.example.botanify.data.repo.PlantRepository
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantViewModel @Inject constructor(
    val plantRepository: PlantRepository
) : ViewModel() {

    private val _plants = MutableStateFlow<Resource<List<Plant>>>(Resource.Loading(null))
    val plants: StateFlow<Resource<List<Plant>>> = _plants

    init {
        fetchPlants()
    }

    fun fetchPlants() {
        viewModelScope.launch {
            plantRepository.fetchPlants().collect { plantsData ->
                _plants.value = plantsData
                Log.d("plantssssssssss", plantsData.toString())
            }
        }
    }
}