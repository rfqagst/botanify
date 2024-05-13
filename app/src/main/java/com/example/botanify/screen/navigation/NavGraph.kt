package com.example.botanify.screen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.botanify.screen.home.HomeScreen
import com.example.botanify.screen.informasi.ListInformasiScreen
import com.example.botanify.screen.notifikasi.NotificationScreen
import com.example.botanify.screen.profile.ProfileScreen
import com.example.botanify.screen.scan.ScanTanamanScreen
import com.example.botanify.screen.search.SearchScreen
import com.example.botanify.screen.tanamansaya.ListTanamanSayaScreen


@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
        HomeScreen(modifier = modifier, navController)
        }
        composable(route = Screen.TanamanSaya.route) {
            ListTanamanSayaScreen(modifier = modifier)
        }
        composable(route = Screen.ScanTanaman.route) {
            ScanTanamanScreen(modifier = modifier)
        }
        composable(route = Screen.Information.route) {
            ListInformasiScreen(modifier = modifier)
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(modifier = modifier)
        }
        composable(route = Screen.Notification.route) {
            NotificationScreen(modifier = modifier)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(modifier = modifier)
        }
    }
}