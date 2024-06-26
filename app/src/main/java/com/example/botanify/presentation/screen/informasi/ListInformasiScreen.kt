package com.example.botanify.presentation.screen.informasi

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.botanify.data.retrofit.response.backend.InformationsResponseItem
import com.example.botanify.presentation.components.InformationHomeCard
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.ui.theme.SurfaceBase
import com.example.botanify.utils.Resource
import formatDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListInformasiScreen(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: InformationViewModel,
) {

    val informationByCategory by viewModel.informationByCategory.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchInformationsByCategory("Semua")
    }

    when (informationByCategory) {
        is Resource.Error -> {
            Log.d("ListInformasiScreen", "Error: ${informationByCategory.message}")
        }

        is Resource.Idle -> {
            // do nothing
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
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(SurfaceBase)
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                ) {
                    LazyColumn {
                        items(infos.size) { index ->
                            val information = infos[index]
                            InformationHomeCard(
                                modifier = Modifier.clickable {
                                    navController.navigate(Screen.DetailInformation.route + "/${information.idInformasi}")
                                },
                                title = information.judul ?: "",
                                date = formatDateTime(information.tanggal ?: ""),
                                image = information.fotoInformasi ?: ""
                            )
                        }
                    }


                }
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewListInformasiScreen() {
//    ListInformasiScreen(modifier = Modifier.padding(16.dp))
}