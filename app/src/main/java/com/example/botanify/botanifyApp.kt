package com.example.botanify

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.botanify.screen.components.BottomBarComponent
import com.example.botanify.screen.components.TopBarComponent
import com.example.botanify.screen.components.TopBarComponentHome
import com.example.botanify.screen.components.TopBarComponentSearch
import com.example.botanify.screen.components.TopBarComponentSearchWithBack
import com.example.botanify.screen.navigation.NavGraph
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.PrimaryBase

@Composable
fun BotanifyApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    Scaffold(
        floatingActionButton = {
            Box {
                FloatingActionButton(
                    onClick = { /* stub */ },
                    containerColor = PrimaryBase,
                    shape = CircleShape,
                    modifier = Modifier

                        .size(50.dp)
                        .align(Alignment.Center)
                        .offset(y = 55.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                        tint = ContentWhite,
                        painter = painterResource(id = R.drawable.ic_scan),
                        contentDescription = null,
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomBarComponent(navController)
        },
        topBar = {
            when (currentDestination) {
                Screen.Home.route -> TopBarComponentHome(navController = navController)
                Screen.DetailInformation.route + "/{informationId}" -> TopBarComponent(title = "Detail Information",navController = navController)
                Screen.TanamanSaya.route -> TopBarComponent(title = "Tanaman Saya",navController = navController)
                Screen.Notification.route -> TopBarComponent(title = "Notification",navController = navController)
                Screen.Profile.route -> TopBarComponent(title = "Profile",navController = navController)
                Screen.Information.route -> TopBarComponentSearch(navController)
                Screen.Search.route -> TopBarComponentSearchWithBack(navController)
            }
        }

    ) { paddingValues ->
        NavGraph(navController = navController, modifier = Modifier.padding(paddingValues))
    }
}


