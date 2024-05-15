package com.example.botanify.screen.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object TanamanSaya : Screen("tanamansaya")
    data object ScanTanaman : Screen("scantanaman")
    data object Information : Screen("information")
    data object Profile : Screen("profile")
    data object Notification : Screen("notification")
    data object SearchTanamanScreen : Screen("searchtanamanscreen")
    data object SearchInformationScreen : Screen("searchtanamanscreen")
    data object DetailTanaman : Screen("detailtanaman")
    data object DetailInformation : Screen("detailinformation")

    data object TambahKoleksiTanaman : Screen("tambahkoleksitanaman")

    data object ForgotPassword : Screen("forgot_password")

    data object Login : Screen("login")

    data object OnBoarding : Screen("onboarding")

    data object Register : Screen("register")


}