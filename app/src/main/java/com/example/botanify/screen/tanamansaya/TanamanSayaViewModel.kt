package com.example.botanify.screen.tanamansaya

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.data.repo.PlantRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TanamanSayaViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    fun addKoleksiTanaman(plantCollection: PlantCollection) {

        currentUser?.let { user ->
            viewModelScope.launch {
                repository.addPlantCollectionToUser(user.uid, plantCollection)
            }
        }


    }

    fun fetchKoleksiTanaman(userId: String) {
        viewModelScope.launch {
            repository.fetchKoleksiTanaman(userId)
        }
    }


    fun uploadImageToStorage (uri : Uri, context: Context, onSuccess: (String) -> Unit) {
        repository.uploadImageToFirebaseStorage(uri, context, onSuccess)
    }
    

}