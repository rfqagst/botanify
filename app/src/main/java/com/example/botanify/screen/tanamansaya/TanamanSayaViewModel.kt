package com.example.botanify.screen.tanamansaya

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.data.repo.PlantRepository
import com.example.botanify.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TanamanSayaViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

    private val _addPlantState = MutableStateFlow<Resource<Unit>>(Resource.Idle())
    val addPlantState: StateFlow<Resource<Unit>> = _addPlantState

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    fun addKoleksiTanaman(plantCollection: PlantCollection) {
        currentUser?.let { user ->
            _addPlantState.value = Resource.Loading()
            viewModelScope.launch {
                try {
                    repository.addPlantCollectionToUser(user.uid, plantCollection)
                    _addPlantState.value = Resource.Success(Unit)
                } catch (e: Exception) {
                    _addPlantState.value = Resource.Error(e.message ?: "Unknown Error")
                }
            }
        }
    }

    fun fetchKoleksiTanaman(userId: String) {
        viewModelScope.launch {
            repository.fetchKoleksiTanaman(userId)
        }
    }


    fun uploadImageToStorage(uri: Uri, context: Context, onSuccess: (String) -> Unit) {
        repository.uploadImageToFirebaseStorage(uri, context, onSuccess)
    }


}