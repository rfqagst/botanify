package com.example.botanify.screen.tanamansaya

import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.data.model.Reminder
import com.example.botanify.data.firebase.repository.PlantRepository
import com.example.botanify.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class TanamanSayaViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

    private val _addPlantState = MutableStateFlow<Resource<PlantCollection>>(Resource.Idle())
    val addPlantState: StateFlow<Resource<PlantCollection>> = _addPlantState

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    fun addKoleksiTanaman(plantCollection: PlantCollection) {
        currentUser?.let { user ->
            viewModelScope.launch {
                try {
                    repository.addPlantCollectionToUserFirebase(user.uid, plantCollection)
                    _addPlantState.value = Resource.Success(plantCollection)
                } catch (e: Exception) {
                    _addPlantState.value = Resource.Error(e.message ?: "Unknown Error")
                }
            }
        }
    }

    fun fetchKoleksiTanaman(userId: String) {
        viewModelScope.launch {
            repository.fetchKoleksiTanamanFirebase(userId)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun uploadImageAndCollectionToStorage(
        plantName: String,
        uri: Uri,
        selectedDates: List<LocalDate>,
        selectedTime: LocalTime,
        context: Context,
    ) {

        viewModelScope.launch {
            _addPlantState.value = Resource.Loading(null)
            repository.uploadImageToFirebaseStorage(uri, context) { imageUrl ->
                val dateFormatter = DateTimeFormatter.ofPattern("MM-dd")
                val reminder = Reminder(
                    dates = selectedDates.map { it.format(dateFormatter) },
                    time = selectedTime.toString()
                )

                val plantCollection = PlantCollection(
                    plantName = plantName,
                    plantImage = imageUrl,
                    reminder = mapOf("reminder1" to reminder)
                )

                addKoleksiTanaman(plantCollection)

            }

        }

    }


}