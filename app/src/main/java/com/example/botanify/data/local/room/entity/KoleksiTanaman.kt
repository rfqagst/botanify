package com.example.botanify.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KoleksiTanaman (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

)