package com.example.botanify.data.model

data class PlantCollection(
    val collectionId: String,
    val plantName: String,
    val plantImage: String,
    val plantNote: String,
    val reminder: Map<String, Reminder> = emptyMap()
) {
    constructor() : this("", "", "", "", emptyMap())

}

