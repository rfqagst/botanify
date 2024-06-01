package com.example.botanify.presentation.navigation

import android.content.Context
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
import com.example.botanify.data.datastore.OnboardingManager
import com.example.botanify.presentation.screen.auth.AuthViewModel
import com.example.botanify.presentation.screen.auth.login.ForgotPassword
import com.example.botanify.presentation.screen.auth.login.LoginScreen
import com.example.botanify.presentation.screen.auth.register.RegisterScreen
import com.example.botanify.presentation.screen.home.HomeScreen
import com.example.botanify.presentation.screen.home.HomeViewModel
import com.example.botanify.presentation.screen.informasi.DetailInformasiScreen
import com.example.botanify.presentation.screen.informasi.InformationViewModel
import com.example.botanify.presentation.screen.informasi.InformationWebView
import com.example.botanify.presentation.screen.informasi.ListInformasiScreen
import com.example.botanify.presentation.screen.notifikasi.NotificationScreen
import com.example.botanify.presentation.screen.onboarding.OnBoarding
import com.example.botanify.presentation.screen.scan.HasilScanScreen
import com.example.botanify.presentation.screen.scan.ScanTanamanScreen
import com.example.botanify.presentation.screen.search.DetailTanamanScreen
import com.example.botanify.presentation.screen.search.PlantViewModel
import com.example.botanify.presentation.screen.search.SearchInformationScreen
import com.example.botanify.presentation.screen.search.SearchTanamanScreen
import com.example.botanify.presentation.screen.tanamansaya.ListTanamanSayaScreen
import com.example.botanify.presentation.screen.tanamansaya.TambahKoleksiTanamanScreen
import com.example.botanify.presentation.screen.tanamansaya.TanamanSayaViewModel
import com.example.botanify.screen.profile.ProfileScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier, context: Context) {

    val onboardingManager by lazy { OnboardingManager(context) }

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            val informationViewModel: InformationViewModel = hiltViewModel()

            HomeScreen(
                modifier = modifier,
                navController,
                homeViewModel = HomeViewModel(),
                informationViewModel
            )
        }

        composable(route = Screen.TanamanSaya.route) {
            ListTanamanSayaScreen(modifier = modifier, navController)
        }

        composable(route = Screen.Information.route) {
            val informationViewModel: InformationViewModel = hiltViewModel()

            ListInformasiScreen(modifier = modifier, navController, informationViewModel)
        }

        composable(
            route = Screen.DetailInformation.route + "/{informationId}",
        ) {
            val informationId = it.arguments?.getString("informationId") ?: ""
            DetailInformasiScreen(modifier = modifier, informationId)
        }


        composable(route = Screen.InformationWebView.route) {
            InformationWebView(modifier)
        }

        composable(route = Screen.Profile.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            ProfileScreen(modifier = modifier, authViewModel, navController)
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

        composable(
            route = Screen.TambahKoleksiTanaman.route,
        ) {
            val tanamanSayaViewModel: TanamanSayaViewModel = hiltViewModel()
            TambahKoleksiTanamanScreen(modifier = modifier, tanamanSayaViewModel)
        }



        composable(route = Screen.OnBoarding.route) {
            OnBoarding(
                onboardingManager = onboardingManager,
                onFinish = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.OnBoarding.route) { inclusive = true }
                    }
                }
            )
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