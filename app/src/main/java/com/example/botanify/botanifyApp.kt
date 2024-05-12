package com.example.botanify

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.botanify.home.HomeScreen
import com.example.botanify.navigation.bottomNavItem
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.Neutral60
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun BotanifyApp() {
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
            BottomBarComponent()
        },

        ) { paddingValues ->
        HomeScreen(modifier = Modifier.padding(paddingValues))

    }
}


@Composable
fun BottomBarComponent() {

    var selected by remember {
        mutableStateOf(0)
    }

    BottomAppBar(
        modifier = Modifier.height(55.dp),
        containerColor = Color.White,
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround, // Left-align icons
                modifier = Modifier.fillMaxWidth()
            ) {
                bottomNavItem.forEachIndexed { index, bottomNavItem ->
                    val id = bottomNavItem.icon
                    IconButton(
                        modifier = Modifier.padding(
                            end = if (id == R.drawable.ic_plant) {
                                80.dp
                            } else {
                                0.dp
                            }
                        ),
                        onClick = { selected = index },
                    ) {
                        Icon(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                            ,
                            tint = if (selected == index) PrimaryBase else Neutral60,
                            painter = painterResource(id = bottomNavItem.icon),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}