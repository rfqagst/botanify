package com.example.botanify.presentation.screen.scan

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.retrofit.repository.PenanggananRepository
import com.example.botanify.data.retrofit.response.scan.Penangganan
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PenanggananViewModel @Inject constructor(
    private val repository: PenanggananRepository
) : ViewModel() {

    private val _penanggananState = MutableStateFlow<Penangganan?>(null)
    val penanggananState: StateFlow<Penangganan?> = _penanggananState


    fun getPenangganan(hama: String, penyakit: String) {
        viewModelScope.launch {
            try {
                var currentPenangganan = Penangganan()

                if (hama.isNotEmpty()) {
                    val hamaResponse = repository.getPenanggananHama(hama)
                    if (hamaResponse.isNotEmpty()) {
                        val firstHama = hamaResponse.first()
                        currentPenangganan = currentPenangganan.copy(
                            idHama = firstHama.idPenanganan ?: 0,
                            namaHama = firstHama.namaHama ?: "",
                            penanggananHama = firstHama.penanganan ?: ""
                        )
                        Log.d("penanggananViewModel", firstHama.penanganan.toString())
                    }
                    _penanggananState.value = currentPenangganan
                }

                if (penyakit.isNotEmpty()) {
                    val penyakitResponse = repository.getPenanggananPenyakit(penyakit)
                    if (penyakitResponse.isNotEmpty()) {
                        val firstPenyakit = penyakitResponse.first()
                        currentPenangganan = currentPenangganan.copy(
                            idPenyakit = firstPenyakit.idPenanganan ?: 0,
                            namaPenyakit = firstPenyakit.namaPenyakit ?: "",
                            penanggananPenyakit = firstPenyakit.penanganan ?: ""
                        )
                        Log.d("penanggananViewModel", firstPenyakit.penanganan.toString())
                    }
                    _penanggananState.value = currentPenangganan
                }

            } catch (e: Exception) {
                Log.e("penanggananViewModel", "Error fetching data", e)
            }
        }
    }
}

