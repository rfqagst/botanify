package com.example.botanify.presentation.screen.scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HasilScanViewModel @Inject constructor(

) : ViewModel() {

    fun getPlantDetail (plantName : String) {
        viewModelScope.launch {

        }
    }

}