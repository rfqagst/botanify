package com.example.botanify.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.botanify.R
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.SecondaryBase
import com.example.botanify.ui.theme.SurfaceBase


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(title: String, navController: NavHostController) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(ContentWhite),
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = ContentDark,
                    textAlign = TextAlign.Center,
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()

            )

        },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                },
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        },
        modifier = Modifier
            .background(ContentWhite)

    )
}


@Composable
fun TopBarComponentSearch(navController: NavHostController, searchText : String, screen : String) {
    Box(
        modifier = Modifier
            .background(ContentWhite)
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable { navController.navigate(screen) }
                .height(45.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(SurfaceBase),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = SecondaryBase,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
            Text(
                text = searchText,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                )
            )
        }
    }
}




@Composable
fun TopBarComponentHome(navController: NavHostController) {
    Column(modifier = Modifier.background(ContentWhite)) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Profile.route)
                        }
                        .clip(RoundedCornerShape(180.dp))
                        .width(50.dp)
                        .height(50.dp),
                    painter = painterResource(id = R.drawable.profile_photo1),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Bonjour,",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight(400),
                            fontStyle = FontStyle.Italic,
                        )
                    )
                    Text(
                        text = "Rifqi Barusadar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight(500),
                        )
                    )
                }
            }

            IconButton(onClick = { navController.navigate(Screen.Notification.route) }) {
                Icon(
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null, tint = SecondaryBase
                )
            }

        }
        SearchBarTanaman(modifier = Modifier
            .padding(16.dp)
            .clickable { navController.navigate(Screen.SearchTanamanScreen.route) })

    }
}


@Preview(showSystemUi = true)
@Composable
fun TopBarComponentPreview() {
    val context = LocalContext.current

}