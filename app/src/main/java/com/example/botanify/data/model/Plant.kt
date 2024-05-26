package com.example.botanify.data.model

data class Plant(
    val id: Int,
    val name: String,
    val description: String,
    val image: String
) {
    constructor() : this(0, "", "", "")
}