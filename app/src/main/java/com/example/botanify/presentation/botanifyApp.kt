package com.example.botanify.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.botanify.R
import com.example.botanify.presentation.components.BottomBarComponent
import com.example.botanify.presentation.components.TopBarComponent
import com.example.botanify.presentation.components.TopBarComponentBack
import com.example.botanify.presentation.components.TopBarComponentHome
import com.example.botanify.presentation.components.TopBarComponentSearch
import com.example.botanify.presentation.navigation.NavGraph
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.screen.auth.AuthViewModel
import com.example.botanify.presentation.ui.theme.ContentWhite
import com.example.botanify.presentation.ui.theme.PrimaryBase

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BotanifyApp(
    authViewModel: AuthViewModel
) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    val currentUser = authViewModel.currentUser?.displayName ?: ""

    Scaffold(
        floatingActionButton = {

            if (currentDestination !in listOf(
                    Screen.OnBoarding.route,
                    Screen.Login.route,
                    Screen.Register.route,
                    Screen.DetailInformation.route + "/{informationId}",
                    Screen.ScanTanaman.route,
                    Screen.HasilScan.route,
                    Screen.DetailTanaman.route + "/{tanamanId}",
                    Screen.TambahKoleksiTanaman.route,
                    Screen.SearchInformationScreen.route,
                    Screen.SearchTanamanScreen.route,
                    Screen.InformationWebView.route


                )
            ) {
                Box {
                    FloatingActionButton(
                        onClick = { navController.navigate(Screen.ScanTanaman.route) },
                        containerColor = PrimaryBase,
                        shape = CircleShape,
                        modifier = Modifier

                            .size(60.dp)
                            .align(Alignment.Center)
                            .offset(y = 60.dp)
                    ) {
                        Icon(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp),
                            tint = ContentWhite,
                            painter = painterResource(id = R.drawable.ic_scan),
                            contentDescription = null,
                        )
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (currentDestination !in listOf(
                    Screen.OnBoarding.route,
                    Screen.Login.route,
                    Screen.Register.route,
                    Screen.ScanTanaman.route,
                    Screen.HasilScan.route,
                    Screen.DetailInformation.route + "/{informationId}",
                    Screen.DetailTanaman.route + "/{tanamanId}",
                    Screen.TambahKoleksiTanaman.route,
                    Screen.SearchInformationScreen.route,
                    Screen.SearchTanamanScreen.route,
                    Screen.InformationWebView.route
                    )
            ) {
                BottomBarComponent(navController)
            }
        },
        topBar = {
            when (currentDestination) {
                Screen.Home.route -> TopBarComponentHome(name = currentUser,navController = navController)
                Screen.DetailInformation.route + "/{informationId}" -> TopBarComponent(
                    title = "Detail Information",
                    navController = navController
                )

                Screen.InformationWebView.route -> TopBarComponent(
                    title = "Detail Informasi",
                    navController = navController
                )

                Screen.TanamanSaya.route -> TopBarComponent(
                    title = "Tanaman Saya",
                    navController = navController
                )

                Screen.Notification.route -> TopBarComponent(
                    title = "Notification",
                    navController = navController
                )

                Screen.Profile.route -> TopBarComponent(
                    title = "Profile",
                    navController = navController
                )

                Screen.Information.route -> TopBarComponentSearch(
                    searchText = "Cari Informasi",
                    navController = navController,
                    screen = Screen.SearchInformationScreen.route
                )

                Screen.DetailTanaman.route + "/{tanamanId}" -> TopBarComponent(
                    title = "Detail Tanaman",
                    navController
                )

                Screen.TambahKoleksiTanaman.route -> TopBarComponent(
                    title = "Tambah Koleksi Tanaman",
                    navController = navController
                )

                Screen.HasilScan.route -> TopBarComponent(
                    title = "Hasil Scan Tanaman",
                    navController = navController
                )

                Screen.Register.route -> TopBarComponentBack(
                    navController = navController
                )
                Screen.SearchTanamanScreen.route -> TopBarComponent(
                    title = "Cari Tanaman",
                    navController = navController
                )
                Screen.SearchInformationScreen.route -> TopBarComponent(
                    title = "Cari Informasi",
                    navController = navController
                )
            }
        }

    ) { paddingValues ->
        NavGraph(navController = navController, modifier = Modifier.padding(paddingValues), context = LocalContext.current)
    }
}

