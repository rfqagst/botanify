package com.example.botanify.data.firebase.model

data class Reminder(
    val dates: List<String> = emptyList(),
    val time: String,
) {
    constructor() : this(emptyList(), "")

}
