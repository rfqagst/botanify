package com.example.botanify.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.botanify.R
import com.example.botanify.screen.navigation.bottomNavItem
import com.example.botanify.ui.theme.Neutral60
import com.example.botanify.ui.theme.PrimaryBase

@Composable
fun BottomBarComponent(navController: NavHostController) {



    var selected by remember {
        mutableStateOf(0)
    }

    BottomAppBar(
        modifier = Modifier.height(70.dp),
        containerColor = Color.White,
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                bottomNavItem.forEachIndexed { index, bottomNavItem ->
                    val id = bottomNavItem
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.wrapContentSize()) {
                        IconButton(
                            modifier = Modifier.padding(
                                end = if (id.icon == R.drawable.ic_plant) {
                                    83.dp
                                } else {
                                    0.dp
                                }
                            ),
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                        ) {
                            Icon(
                                modifier = Modifier
                                    .width(28.dp)
                                    .height(28.dp),
                                tint = if (selected == index) PrimaryBase else Neutral60,
                                painter = painterResource(id = bottomNavItem.icon),
                                contentDescription = null
                            )

                        }
                        Text(
                            modifier = Modifier.padding(
                                end = if (id.icon == R.drawable.ic_plant) {
                                    83.dp
                                } else {
                                    0.dp
                                }
                            ).offset(y = -10.dp),
                            fontSize = 14.sp,
                            text = bottomNavItem.title,
                            color = if (selected == index) PrimaryBase else Neutral60
                        )
                    }
                }
            }
        }
    )
}


@Preview
@Composable
fun BottomBarComponentPreview() {
    val cont = LocalContext.current
    BottomBarComponent(navController = remember { NavHostController(cont) })
}