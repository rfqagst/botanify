package com.example.botanify.data.local

data class FilterData(
    val category: String,
    val isActive: Boolean = false,
)

val categoryList = listOf(
    FilterData(
        category = "Tips & Trik",
        isActive = true
    ),
    FilterData(
        category = "Penyakit",
    ),
    FilterData(
        category = "Hama",
    ),
    FilterData(
        category = "Budidaya",
    ),
    FilterData(
        category = "Event",
    )

)