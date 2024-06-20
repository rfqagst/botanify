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
        "hama-semut",
        "catterpillar",
        "ladybug",
        "thrips",
        "whitefly",
        "aphids"
    )

    val listPenyakit = listOf(
        "black-spot",
        "powdery-mildew"
    )

    fun getPenangganan(hamaPenyakit: String) {

        viewModelScope.launch {
            Log.d("penanggananViewModel", "Fetching data for $hamaPenyakit")
            _penanggananState.value = PenanggananUiState.Loading

            try {
                var currentPenangganan = Penangganan()

                val hamaPenyakits = hamaPenyakit.split(",").map { it.trim() }.filter { it.isNotEmpty() }

                val hamaPenyakitFormatted = hamaPenyakits.first().replace("-", " ")
                Log.d("penanggananViewModel", hamaPenyakitFormatted)
                val hamaPenyakit = hamaPenyakits.first()

                if (hamaPenyakit in listHama) {
                    val hamaResponse = repository.getPenanggananHama(hamaPenyakitFormatted)

                    val firstHama = hamaResponse.first()
                    currentPenangganan = currentPenangganan.copy(
                        idHama = firstHama.idPenanganan ?: 0,
                        namaHama = firstHama.namaHama ?: "",
                        penanggananHama = firstHama.penanganan ?: ""
                    )
                    Log.d("penanggananViewModel", firstHama.penanganan.toString())

                } else if (hamaPenyakit  in listPenyakit) {
                    val penyakitResponse = repository.getPenanggananPenyakit(hamaPenyakitFormatted)
                    val firstPenyakit = penyakitResponse.first()
                    currentPenangganan = currentPenangganan.copy(
                        idPenyakit = firstPenyakit.idPenanganan ?: 0,
                        namaPenyakit = firstPenyakit.namaPenyakit ?: "",
                        penanggananPenyakit = firstPenyakit.penanganan ?: ""
                    )
                    Log.d("penanggananViewModel", firstPenyakit.penanganan.toString())

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
    object Error : PenanggananUiState
    object Loading : PenanggananUiState
}
