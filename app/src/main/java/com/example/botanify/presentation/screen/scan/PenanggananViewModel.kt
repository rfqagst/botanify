package com.example.botanify.presentation.screen.scan

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.retrofit.repository.PenanggananRepository
import com.example.botanify.data.retrofit.response.backend.HamaResponseItem
import com.example.botanify.data.retrofit.response.backend.PenyakitResponseItem
import com.example.botanify.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PenanggananViewModel @Inject constructor(
    private val repository: PenanggananRepository
) : ViewModel() {

    private val _penanggananPenyakitState =
        MutableStateFlow<Resource<List<PenyakitResponseItem>>>(Resource.Idle())
    val penanggananPenyakitState: StateFlow<Resource<List<PenyakitResponseItem>>> =
        _penanggananPenyakitState

    private val _penanggananHamaState =
        MutableStateFlow<Resource<List<HamaResponseItem>>>(Resource.Idle())
    val penanggananHamaState: StateFlow<Resource<List<HamaResponseItem>>> =
        _penanggananHamaState

    fun getPenaggananPenyakit(namaPenyakit: String) {
        viewModelScope.launch {
            repository.getPenanggananPenyakit(namaPenyakit).collect { result ->
                _penanggananPenyakitState.value = result
                Log.d(
                    "PenanggananViewModel",
                    "getPenaggananPenyakit: $result.data"
                )
            }

        }
    }


    fun getPenaggananHama(namaHama: String) {
        viewModelScope.launch {
            repository.getPenanggananHama(namaHama).collect { result ->
                _penanggananHamaState.value = result
                Log.d(
                    "PenanggananViewModel",
                    "PenanggananHama: $result.data"
                )
            }

        }
    }
}