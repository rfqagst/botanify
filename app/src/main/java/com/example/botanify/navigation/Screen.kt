package com.example.botanify.navigation

sealed class Screen(val route: String) {
data object Home : Screen("home")
data object TanamanSaya : Screen("tanamansaya")
data object ScanTanaman : Screen("scantanaman")
data object Information : Screen("information")
data object Profile : Screen("profile")
}