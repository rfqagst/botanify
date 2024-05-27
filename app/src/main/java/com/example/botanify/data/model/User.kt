package com.example.botanify.data.model

data class User(
    val id: String = "",
    val name: String = "",
    val email : String = "",
    val plantCollection : Map<String, PlantCollection> = emptyMap()
)
