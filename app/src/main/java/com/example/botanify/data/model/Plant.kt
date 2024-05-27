package com.example.botanify.data.model

data class Plant(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val image: String = ""
) {
    constructor() : this("", "", "", "")
}