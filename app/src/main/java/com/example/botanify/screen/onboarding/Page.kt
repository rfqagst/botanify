package com.example.botanify.screen.onboarding

import androidx.annotation.DrawableRes
import com.example.botanify.R

data class Page(
    val title: String,
    val desc: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title  ="Pemindaian yang Cepat dan Akurat",
        desc = "Kami menggunakan teknologi canggih untuk memberikan hasil yang akurat dengan cepat.",
        image = R.drawable.on_boarding_1
    ),
    Page(
        title  ="Ingatkan Perawatan Tanaman Anda",
        desc = "Dengan fitur Reminder, Anda tidak akan pernah lagi melewatkan waktu penyiraman tanaman Anda.",
        image = R.drawable.on_boarding_2
    ),
)