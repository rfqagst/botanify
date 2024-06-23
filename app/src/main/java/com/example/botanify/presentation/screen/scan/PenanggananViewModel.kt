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

    private val _penanggananState = MutableStateFlow<PenanggananUiState>(PenanggananUiState.Loading)
    val penanggananState: StateFlow<PenanggananUiState?> = _penanggananState

    val listHama = listOf(
        "hama semut",
        "catterpillar",
        "ladybug",
        "thrips",
        "whitefly",
        "aphids"
    )

    val listPenyakit = listOf(
        "black spot",
        "powdery mildew"
    )

    fun getPenangganan(hamaPenyakit: String) {

        viewModelScope.launch {
            Log.d("penanggananViewModel", "Fetching data for $hamaPenyakit")
            _penanggananState.value = PenanggananUiState.Loading

            try {
                var currentPenangganan = Penangganan()

                val formattedHamaPenyakit = hamaPenyakit.replace("-", " ")
                val hamaPenyakits = formattedHamaPenyakit.split(",").map { it.trim() }.filter { it.isNotEmpty() }


                if (hamaPenyakits.isEmpty()) {
                    _penanggananState.value = PenanggananUiState.NotFound(currentPenangganan)
                    return@launch
                }

                val firstHamaPenyakit = hamaPenyakits.first()


                Log.d("penanggananViewModel", firstHamaPenyakit)
                Log.d("penanggananViewModel", hamaPenyakit)

                if (firstHamaPenyakit in listHama) {
                    val hamaResponse = repository.getPenanggananHama(firstHamaPenyakit)
                    if (hamaResponse.isEmpty()) {
                        _penanggananState.value = PenanggananUiState.NotFound(currentPenangganan)
                        return@launch
                    }
                    val firstHama = hamaResponse.first()
                    currentPenangganan = currentPenangganan.copy(
                        idHama = firstHama.idPenanganan ?: 0,
                        namaHama = firstHama.namaHama ?: "",
                        penanggananHama = firstHama.penanganan ?: ""
                    )
                    Log.d("penanggananViewModel", firstHama.penanganan.toString())

                } else if (firstHamaPenyakit in listPenyakit) {
                    val penyakitResponse = repository.getPenanggananPenyakit(firstHamaPenyakit)
                    if (penyakitResponse.isEmpty()) {
                        _penanggananState.value = PenanggananUiState.NotFound(currentPenangganan)
                        return@launch
                    }
                    val firstPenyakit = penyakitResponse.first()
                    currentPenangganan = currentPenangganan.copy(
                        idPenyakit = firstPenyakit.idPenanganan ?: 0,
                        namaPenyakit = firstPenyakit.namaPenyakit ?: "",
                        penanggananPenyakit = firstPenyakit.penanganan ?: ""
                    )
                    Log.d("penanggananViewModel", firstPenyakit.penanganan.toString())
                } else {
                    _penanggananState.value = PenanggananUiState.NotFound(currentPenangganan)
                    return@launch
                }

                _penanggananState.value = PenanggananUiState.Success(currentPenangganan)

            } catch (e: Exception) {
                Log.e("penanggananViewModel", "Error fetching data", e)
                _penanggananState.value = PenanggananUiState.Error
            }
        }
    }
}

sealed interface PenanggananUiState {
    data class Success(val penangganan: Penangganan) : PenanggananUiState
    data class NotFound(val penangganan: Penangganan) : PenanggananUiState
    object Error : PenanggananUiState
    object Loading : PenanggananUiState
}
