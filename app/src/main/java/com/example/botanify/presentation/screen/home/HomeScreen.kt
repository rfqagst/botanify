package com.example.botanify.presentation.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.botanify.data.retrofit.response.backend.InformationsResponseItem
import com.example.botanify.presentation.components.BannerCard
import com.example.botanify.presentation.components.FilterButton
import com.example.botanify.presentation.components.InformationHomeCard
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.screen.informasi.InformationViewModel
import com.example.botanify.presentation.ui.theme.SecondaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase
import com.example.botanify.utils.Resource

@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    informationViewModel: InformationViewModel
) {

    val informationByCategory by informationViewModel.informationByCategory.collectAsState()


    val filterState by homeViewModel.filters.collectAsState()
    val selectedCategory by homeViewModel.selectedCategory.collectAsState()

//    LaunchedEffect(selectedCategory) {
//        informationViewModel.fetchInformations()
//    }

    Column(modifier = modifier.background(SurfaceBase)) {
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
                            fontSize = 14.sp,
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
                        FilterButton(
                            modifier = Modifier.clickable {
                                homeViewModel.toggleFilter(index)
                                informationViewModel.fetchInformationsByCategory(category.category)
                            },
                            category.category,
                            isActive = category.isActive
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            when (informationByCategory) {
                is Resource.Error -> {
                    Log.d("ListInformasiScreen", "Error: ${informationByCategory.message}")
                }

                is Resource.Idle -> {
                    TODO()
                }

                is Resource.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(top = 36.dp)
                                .size(48.dp)
                        )
                    }
                }

                is Resource.Success -> {
                    val informations =
                        (informationByCategory as Resource.Success<List<InformationsResponseItem>>).data

                    informations?.let { infos ->
                        HomeArticles(navController, infos)
                    }
                }


            }


        }
    }
}


@Composable
fun HomeArticles(navController: NavHostController, infos: List<InformationsResponseItem>) {
    LazyColumn {
        items(infos.size) { index ->
            val information = infos[index]
            InformationHomeCard(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.DetailInformation.route + "/${information.idInformasi}")
                },
                title = information.judul ?: "",
                date = information.tanggal ?: "",
                image = information.fotoInformasi ?: "",
            )
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