package com.example.botanify.screen.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.botanify.screen.auth.login.ForgotPassword
import com.example.botanify.screen.auth.login.LoginScreen
import com.example.botanify.screen.auth.register.RegisterScreen
import com.example.botanify.screen.home.HomeScreen
import com.example.botanify.screen.home.HomeViewModel
import com.example.botanify.screen.informasi.DetailInformasiScreen
import com.example.botanify.screen.informasi.ListInformasiScreen
import com.example.botanify.screen.notifikasi.NotificationScreen
import com.example.botanify.screen.onboarding.OnBoarding
import com.example.botanify.screen.profile.ProfileScreen
import com.example.botanify.screen.scan.HasilScanScreen
import com.example.botanify.screen.scan.ScanTanamanScreen
import com.example.botanify.screen.search.DetailTanamanScreen
import com.example.botanify.screen.search.SearchInformationScreen
import com.example.botanify.screen.search.SearchTanamanScreen
import com.example.botanify.screen.tanamansaya.ListTanamanSayaScreen
import com.example.botanify.screen.tanamansaya.TambahKoleksiTanamanScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {

    NavHost(navController = navController, startDestination = Screen.OnBoarding.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(modifier = modifier, navController, homeViewModel = HomeViewModel())
        }

        composable(route = Screen.TanamanSaya.route) {
            ListTanamanSayaScreen(modifier = modifier)
        }


        composable(route = Screen.Information.route) {
            ListInformasiScreen(modifier = modifier, navController)
        }

        composable(
            route = Screen.DetailInformation.route + "/{informationId}",
        ) {
            val informationId = it.arguments?.getString("informationId") ?: ""
            DetailInformasiScreen(modifier = modifier, informationId)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(modifier = modifier)
        }

        composable(route = Screen.Notification.route) {
            NotificationScreen(modifier = modifier)
        }

        composable(route = Screen.SearchTanamanScreen.route) {
            SearchTanamanScreen(modifier = modifier, navController)
        }

        composable(route = Screen.SearchInformationScreen.route) {
            SearchInformationScreen(modifier = modifier, navController)
        }

        composable(route = Screen.DetailTanaman.route + "/{tanamanId}") {
            val tanamanId = it.arguments?.getString("tanamanId") ?: ""
            DetailTanamanScreen(modifier = modifier, tanamanId)
        }

        composable(route = Screen.TambahKoleksiTanaman.route) {
            TambahKoleksiTanamanScreen(modifier = modifier)
        }

        composable(route = Screen.ForgotPassword.route) {
            ForgotPassword(navController)
        }

        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoarding(navController)
        }

        composable(route = Screen.Register.route) {
            RegisterScreen(navController)
        }

        composable(route = Screen.ScanTanaman.route) {
            ScanTanamanScreen(modifier = modifier, navController)
        }

        composable(route = Screen.HasilScan.route) {
            HasilScanScreen(modifier = modifier)
        }

    }
}