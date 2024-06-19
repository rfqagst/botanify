package com.example.botanify.presentation.screen.scan

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.retrofit.repository.ScanRepository
import com.example.botanify.data.retrofit.response.scan.ScanResult
import com.example.botanify.utils.Resource
import com.example.botanify.utils.toFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor(
    private val repository: ScanRepository
) : ViewModel() {


    private val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    fun selectedImageUri(uri: Uri) {
        _selectedImageUri.value = uri
    }

    private val _scanState = MutableStateFlow<ScanState>(ScanState.Idle)
    val scanState: StateFlow<ScanState> = _scanState

    fun scanPlant(file: File) {
        viewModelScope.launch {
            _scanState.value = ScanState.LoadingIdentifyPlantName
            val identifyPlantName = repository.identifyPlantName(file)
            when (identifyPlantName) {
                is Resource.Error -> {
                    Log.e("ScanViewModel", "identifyPlantName: ${identifyPlantName.message}")
                }

                is Resource.Idle,

                is Resource.Loading,

                is Resource.Success -> {
                    val identifyPlantDiseases = repository.classifyPlantDiseasesPests(file)
                    when (identifyPlantDiseases) {
                        is Resource.Error -> {
                            Log.e(
                                "ScanViewModel",
                                "identifyPlantDiseases: ${identifyPlantDiseases.message}"
                            )

                        }

                        is Resource.Idle,

                        is Resource.Loading -> {
                            _scanState.value = ScanState.LoadingIdentifyPlantDiseases
                        }

                        is Resource.Success -> {
                            _scanState.value = ScanState.ScanResult(
                                identifyPlantName.data?.category ?: "Unknown plant",
                                identifyPlantDiseases.data?.predictions?.joinToString(", ") {
                                    it.jsonMemberClass ?: "Unknown disease"
                                } ?: "No diseases found",
                                _selectedImageUri.value.toString()
                            )
                        }
                    }

                }
            }
        }


    }


}


sealed interface ScanState {
    data object Idle : ScanState
    data object LoadingIdentifyPlantName : ScanState
    data object LoadingIdentifyPlantDiseases : ScanState
    data class ScanResult(
        val plantName: String,
        val disease: String,
        val userImageUri: String
    ) : ScanState

    data class Error(val message: String) : ScanState
}