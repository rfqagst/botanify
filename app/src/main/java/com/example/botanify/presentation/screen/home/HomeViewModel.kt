package com.example.botanify.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.example.botanify.data.dummy.FilterData
import com.example.botanify.data.dummy.categoryList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _filters = MutableStateFlow(categoryList)
    val filters: StateFlow<List<FilterData>> = _filters

    private val _selectedCategory = MutableStateFlow("Semua")
    val selectedCategory: StateFlow<String> = _selectedCategory
    fun toggleFilter(index: Int) {
        _filters.update { currentFilter ->
            currentFilter.mapIndexed { i, filter ->
                filter.copy(isActive = i == index).also {
                    if (i == index) {
                        _selectedCategory.update { filter.category }
                    }
                }
            }

        }
    }
}

