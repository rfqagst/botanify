package com.example.botanify.data.firebase.model

data class Plant(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val image: String = ""
) {
    constructor() : this("", "", "", "")
}