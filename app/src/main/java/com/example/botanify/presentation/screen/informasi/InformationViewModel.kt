package com.example.botanify.presentation.screen.informasi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.retrofit.repository.InformationRepository
import com.example.botanify.data.retrofit.response.backend.DetailInformationItem
import com.example.botanify.data.retrofit.response.backend.InformationDetailResponse
import com.example.botanify.data.retrofit.response.backend.InformationsResponseItem
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationViewModel @Inject constructor(
    private val repository: InformationRepository
) : ViewModel() {


    private val _informationById =
        MutableStateFlow<Resource<InformationDetailResponse>>(Resource.Loading(null))
    val informationById: StateFlow<Resource<InformationDetailResponse>> = _informationById


    private val _informationByCategory =
        MutableStateFlow<Resource<List<InformationsResponseItem>>>(Resource.Loading(null))
    val informationByCategory: StateFlow<Resource<List<InformationsResponseItem>>> =
        _informationByCategory


    init {
        fetchInformationsByCategory("Semua")
    }


    fun fetchInformationsByCategory(category: String) {
        if (category == "Semua") {
            viewModelScope.launch {
                repository.getInformations().collect { informationsData ->
                    _informationByCategory.value = informationsData
                    Log.d("plantssssssssss", informationsData.toString())
                }
            }
        } else {
            viewModelScope.launch {
                repository.getInformationsByCategory(category).collect { informationsData ->
                    _informationByCategory.value = informationsData
                    Log.d("plantssssssssss", informationsData.toString())
                }
            }
        }
    }


    fun fetchInformationById(informationId: String) {
        viewModelScope.launch {
            repository.getInformationsById(informationId).collect { informationsData ->
                _informationById.value = informationsData
                Log.d("PlantViewModel", "Plant data fetched: ${informationsData.data}")
            }
        }
    }


}