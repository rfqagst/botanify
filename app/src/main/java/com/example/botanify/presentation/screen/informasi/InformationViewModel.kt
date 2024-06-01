package com.example.botanify.presentation.screen.informasi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.firebase.repository.InformationRepositoryFB
import com.example.botanify.data.model.Information
import com.example.botanify.data.model.Plant
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationViewModel @Inject constructor(
    private val repository: InformationRepositoryFB
) : ViewModel() {

    private val _informations = MutableStateFlow<Resource<List<Information>>>(Resource.Loading(null))
    val informations: StateFlow<Resource<List<Information>>> = _informations


    private val _informationById = MutableStateFlow<Resource<Information>>(Resource.Loading(null))
    val informationById: StateFlow<Resource<Information>> = _informationById


    init {
        fetchInformations()
    }

    fun fetchInformations(category: String? = null) {
        viewModelScope.launch {
            repository.fetchInformationsFirebase(category).collect { informationsData ->
                _informations.value = informationsData
                Log.d("plantssssssssss", informationsData.toString())
            }
        }
    }


    fun fetchPlantById(informationId: String) {
        viewModelScope.launch {
            repository.fetchInformationByIdFirebase(informationId).collect { informationsData ->
                _informationById.value = informationsData
                Log.d("PlantViewModel", "Plant data fetched: $informationsData")
            }
        }
    }


}