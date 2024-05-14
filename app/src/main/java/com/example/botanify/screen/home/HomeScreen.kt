package com.example.botanify.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.botanify.data.local.categoryList
import com.example.botanify.data.local.informationData
import com.example.botanify.screen.components.BannerCard
import com.example.botanify.screen.components.FilterButton
import com.example.botanify.screen.components.InformationHomeCard
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.SecondaryBase

@Composable
fun HomeScreen(modifier: Modifier, navController: NavHostController, homeViewModel: HomeViewModel) {

    val informationData = informationData

    val filterState = homeViewModel.filters

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(4.dp))

        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp)) {
            BannerCard(modifier = Modifier, navController)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Informasi Tanaman",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Pelajari lebih lanjut tentang tanaman",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(400),
                        )
                    )
                }
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.Information.route)
                    },
                    text = "Lihat semua",
                    color = SecondaryBase,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))


            LazyRow {
                items(filterState.size) { index ->
                    filterState[index].let { category ->
                        FilterButton(modifier = Modifier.clickable {
                            homeViewModel.toggleFilter(index)
                        }, category.category, isActive = category.isActive)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(informationData.size) { index ->
                    informationData[index].let { information ->
                        InformationHomeCard(
                            modifier = Modifier.clickable {
                                val informationId = information.id
                                navController.navigate(Screen.DetailInformation.route + "/$informationId")
                            },
                            title = information.title,
                            date = information.date, image = information.image
                        )
                    }
                }
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
//    HomeScreen(
//        modifier = Modifier
//            .padding(16.dp), navController = NavHostController(L)
//    )
}