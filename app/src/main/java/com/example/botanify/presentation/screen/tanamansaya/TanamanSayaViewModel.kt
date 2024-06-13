package com.example.botanify.presentation.screen.tanamansaya

import android.content.Context
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.firebase.repository.PlantRepositoryFB
import com.example.botanify.data.firebase.model.PlantCollection
import com.example.botanify.data.firebase.model.Reminder
import com.example.botanify.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TanamanSayaViewModel @Inject constructor(
    private val repository: PlantRepositoryFB
) : ViewModel() {

    private val _addPlantState = MutableStateFlow<Resource<PlantCollection>>(Resource.Idle())
    val addPlantState: StateFlow<Resource<PlantCollection>> = _addPlantState

    private val _plantCollection =
        MutableStateFlow<Resource<List<PlantCollection>>>(Resource.Idle())
    val plantCollection: StateFlow<Resource<List<PlantCollection>>> = _plantCollection

    private val _deletePlantState = MutableStateFlow<Resource<Boolean>>(Resource.Idle())
    val deletePlantState: StateFlow<Resource<Boolean>> = _deletePlantState
    val currentUser: FirebaseUser?
        get() = repository.currentUser


    init {
        val userId = currentUser?.uid ?: ""

        fetchKoleksiTanamanUser(userId)

    }

    private fun addKoleksiTanaman(plantCollection: PlantCollection) {
        currentUser?.let { user ->
            viewModelScope.launch {
                try {
                    repository.addPlantCollectionToUserFirebase(user.uid, plantCollection)
                    Log.d("TanamanSayaVM", "${user.email}, ${user.uid}")
                    _addPlantState.value = Resource.Success(plantCollection)
                } catch (e: Exception) {
                    _addPlantState.value = Resource.Error(e.message ?: "Unknown Error")
                }
            }
        }
    }

    private fun fetchKoleksiTanamanUser(userId: String) {
        viewModelScope.launch {
            repository.fetchPlantCollectionsFirebase(userId).collect { collectionData ->
                _plantCollection.value = collectionData
                Log.d("TanamanSayaVM", " id user: $userId, Data: $collectionData")
            }
        }
    }

    fun deletePlantCollection(userId: String, plantCollectionId: String) {
        viewModelScope.launch {
            repository.detelePlantCollectionFirebase(userId, plantCollectionId).collect { result ->
                _deletePlantState.value = result
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun uploadImageAndCollectionToStorage(
        plantName: String,
        plantNote: String,
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
                    collectionId = UUID.randomUUID().toString(),
                    plantName = plantName,
                    plantImage = imageUrl,
                    plantNote = plantNote,
                    reminder = mapOf("reminder1" to reminder)
                )

                addKoleksiTanaman(plantCollection)

            }

        }

    }


}