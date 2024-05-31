package com.example.botanify.presentation.navigation

import com.example.botanify.R

data class BottomNavItem(
    val title: String,
    val icon: Int,
    val route: String
)

var bottomNavItem = listOf(
    BottomNavItem(
        title = "Home",
        icon = R.drawable.ic_home,
        route = "home"
    ),
    BottomNavItem(
        title = "Tanaman",
        icon = R.drawable.ic_plant,
        route = "tanamansaya"
    ),
    BottomNavItem(
        title = "Info",
        icon = R.drawable.ic_book,
        route = "information"
    ),
    BottomNavItem(
        title = "Profile",
        icon = R.drawable.ic_person_nav,
        route = "profile"
    ),

    )