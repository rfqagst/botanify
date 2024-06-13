package com.example.botanify.data.firebase.model

data class Information(
    val id : String,
    val title : String,
    val date : String,
    val kategori : String,
    val deskripsi : String,
    val image : String,
    val url : String,
) {
    constructor() : this("","","","","","","")
}
