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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.botanify.screen.components.BottomBarComponent
import com.example.botanify.screen.navigation.NavGraph
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.PrimaryBase

@Composable
fun BotanifyApp() {
    val navController = rememberNavController()

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

        ) { paddingValues ->
        NavGraph(navController = navController, modifier = Modifier.padding(paddingValues))
    }
}


