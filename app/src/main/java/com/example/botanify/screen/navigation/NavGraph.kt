package com.example.botanify.screen.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.botanify.screen.auth.AuthViewModel
import com.example.botanify.screen.auth.login.ForgotPassword
import com.example.botanify.screen.auth.login.LoginScreen
import com.example.botanify.screen.auth.register.RegisterScreen
import com.example.botanify.screen.home.HomeScreen
import com.example.botanify.screen.home.HomeViewModel
import com.example.botanify.screen.informasi.DetailInformasiScreen
import com.example.botanify.screen.informasi.ListInformasiScreen
import com.example.botanify.screen.notifikasi.NotificationScreen
import com.example.botanify.screen.onboarding.OnBoarding
import com.example.botanify.screen.scan.HasilScanScreen
import com.example.botanify.screen.scan.ScanTanamanScreen
import com.example.botanify.screen.search.DetailTanamanScreen
import com.example.botanify.screen.search.PlantViewModel
import com.example.botanify.screen.search.SearchInformationScreen
import com.example.botanify.screen.search.SearchTanamanScreen
import com.example.botanify.screen.search.profile.ProfileScreen
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
            val authViewModel: AuthViewModel = hiltViewModel()
            ProfileScreen(modifier = modifier, authViewModel)
        }

        composable(route = Screen.Notification.route) {
            NotificationScreen(modifier = modifier)
        }

        composable(route = Screen.SearchTanamanScreen.route) {
            val plantViewModel: PlantViewModel = hiltViewModel()
            SearchTanamanScreen(modifier = modifier, navController, plantViewModel)
        }

        composable(route = Screen.SearchInformationScreen.route) {
            SearchInformationScreen(modifier = modifier, navController)
        }

        composable(
            route = Screen.DetailTanaman.route + "/{tanamanId}",
            arguments = listOf(navArgument("tanamanId") { type = NavType.StringType })

        ) {
            val plantViewModel: PlantViewModel = hiltViewModel()
            val tanamanId = it.arguments?.getString("tanamanId") ?: ""
            DetailTanamanScreen(modifier = modifier, tanamanId, plantViewModel)
        }

        composable(route = Screen.TambahKoleksiTanaman.route) {
            TambahKoleksiTanamanScreen(modifier = modifier)
        }



        composable(route = Screen.OnBoarding.route) {
//            OnBoarding(
//                onboardingManager = onboardingManager,
//                onFinish = {
//                    navController.navigate(Screen.Register.route)
//                }
//            )
        }

        composable(route = Screen.Register.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            RegisterScreen(modifier = modifier, navController, authViewModel)
        }

        composable(route = Screen.Login.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            LoginScreen(modifier, navController, authViewModel)
        }

        composable(route = Screen.ForgotPassword.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            ForgotPassword(modifier, navController, authViewModel)
        }


        composable(route = Screen.ScanTanaman.route) {
            ScanTanamanScreen(modifier = modifier, navController)
        }

        composable(route = Screen.HasilScan.route) {
            HasilScanScreen(modifier = modifier)
        }


    }
}