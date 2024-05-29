package com.example.botanify.screen.navigation

sealed class Screen(val route: String) {

    data object OnBoarding : Screen("onboarding")
    data object ForgotPassword : Screen("forgot_password")
    data object Login : Screen("login")
    data object Register : Screen("register")


    data object Profile : Screen("profile")
    data object Home : Screen("home")
    data object Notification : Screen("notification")


    data object TanamanSaya : Screen("tanamansaya")
    data object TambahKoleksiTanaman : Screen("tambahkoleksitanaman")


    data object SearchTanamanScreen : Screen("searchtanamanscreen")
    data object SearchInformationScreen : Screen("searchinformationscreen")
    data object DetailTanaman : Screen("detailtanaman")


    data object Information : Screen("information")
    data object DetailInformation : Screen("detailinformation")


    data object ScanTanaman : Screen("scantanaman")
    data object HasilScan : Screen("hasilscan")


}