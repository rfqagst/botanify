package com.example.botanify.presentation.screen.scan

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.retrofit.repository.ScanRepository
import com.example.botanify.data.retrofit.response.scan.PredictionsResponse
import com.example.botanify.data.retrofit.response.scan.ScanPlantResponse
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor(
    private val repository: ScanRepository
) : ViewModel() {

    private val _identifyPlantNameState =
        MutableStateFlow<Resource<ScanPlantResponse>>(Resource.Idle())
    val identifyPlantNameState: StateFlow<Resource<ScanPlantResponse>> = _identifyPlantNameState

    private val _identifyPlantDiseasesState =
        MutableStateFlow<Resource<PredictionsResponse>>(Resource.Idle())
    val identifyPlantDiseasesState: StateFlow<Resource<PredictionsResponse>> =
        _identifyPlantDiseasesState

    private val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    fun selectedImageUri(uri: Uri) {
        _selectedImageUri.value = uri
    }


    fun scanPlant(image: File) {
        viewModelScope.launch {
            _identifyPlantNameState.value = Resource.Loading()

            repository.identifyPlantName(image).collect { result ->
                _identifyPlantNameState.value = result
                _identifyPlantDiseasesState.value = Resource.Loading()
                if (result is Resource.Success) {
                    repository.classifyPlantDiseasesPests(image).collect { diseaseResult ->
                        _identifyPlantDiseasesState.value = diseaseResult

                    }
                } else if (result is Resource.Error) {
                    _identifyPlantDiseasesState.value =
                        Resource.Error("Failed to identify plant name, skipping disease identification")
                }
            }
        }
    }


}


