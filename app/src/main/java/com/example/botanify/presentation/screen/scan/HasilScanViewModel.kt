package com.example.botanify.presentation.screen.scan

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.retrofit.repository.PlantRepository
import com.example.botanify.data.retrofit.response.backend.PlantDetailResponse
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class HasilScanViewModel @Inject constructor(
    private val plantRepository: PlantRepository
) : ViewModel() {


    private val _plantDetail = MutableStateFlow<Resource<PlantDetailResponse>>(Resource.Loading())
    val plantDetail: StateFlow<Resource<PlantDetailResponse>> = _plantDetail


    fun fetchPlantByName(plantName: String) {
        viewModelScope.launch {
            _plantDetail.value = Resource.Loading()
            try {
                val resource = plantRepository.getPlantByName(plantName)
                _plantDetail.value = resource
                Log.d("HasilScanViewModels", "Plant data fetched: ${resource.data?.data?.deskripsiTanaman}")
            } catch (e: Exception) {
                _plantDetail.value = Resource.Error("Error fetching plant by name: ${e.message}")
                Log.e("HasilScanViewModels", "Error fetching plant by name : ${e.message}")
            }
        }
    }
}