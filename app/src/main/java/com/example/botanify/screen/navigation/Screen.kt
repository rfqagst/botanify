package com.example.botanify.screen.navigation

sealed class Screen(val route: String) {
data object Home : Screen("home")
data object TanamanSaya : Screen("tanamansaya")
data object ScanTanaman : Screen("scantanaman")
data object Information : Screen("information")
data object DetailInformation : Screen("detailinformation")
data object Profile : Screen("profile")
data object Notification : Screen("notification")
data object Search : Screen("search")
data object DetailTanaman : Screen("detailtanaman")
}