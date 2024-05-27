package com.example.botanify.data.model

data class PlantCollection(
    val plantName: String,
    val plantImage: String,
    val reminder : Map<String, Reminder> = emptyMap()
)
