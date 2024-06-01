package com.example.botanify.data.local

data class FilterData(
    val category: String,
    val isActive: Boolean = false,
)

val categoryList = listOf(
    FilterData(
        category = "Semua",
        isActive = true
    ),
    FilterData(
        category = "Tips & Trick",
        ),
    FilterData(
        category = "Penyakit & Hama",
    ),
    FilterData(
        category = "Informasi",
    ),
)