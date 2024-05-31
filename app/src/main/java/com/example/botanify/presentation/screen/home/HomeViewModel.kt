package com.example.botanify.presentation.screen.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.botanify.data.local.categoryList

class HomeViewModel : ViewModel() {

    var filters = mutableStateListOf(*categoryList.toTypedArray())
        private set

    fun toggleFilter(index: Int) {
        filters.forEachIndexed { idx, filter ->
            filters[idx] = filter.copy(isActive = (idx == index))
        }
    }
}

