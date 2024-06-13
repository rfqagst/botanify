package com.example.botanify.presentation.screen.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.botanify.R
import com.example.botanify.data.retrofit.response.backend.DataItem
import com.example.botanify.data.retrofit.response.backend.PlantResponse
import com.example.botanify.presentation.components.SearchTanamanCard
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.ui.theme.SecondaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase
import com.example.botanify.utils.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTanamanScreen(
    modifier: Modifier,
    navController: NavHostController,
    plantViewModel: PlantViewModel

) {

    var textSearch by remember {
        mutableStateOf("")
    }

    var activeSearch by remember {
        mutableStateOf(true)
    }

    val plantData by plantViewModel.plants.collectAsState()

    SearchBar(
        modifier = modifier,
        colors = SearchBarDefaults.colors(SurfaceBase),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = "Kamboja Jepang",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                )
            )
        },
        query = textSearch,
        onQueryChange = {
            textSearch = it
        },
        onSearch = { activeSearch = true },
        active = activeSearch,
        onActiveChange = {
            activeSearch = it
        },
        leadingIcon = {
            Icon(
                tint = SecondaryBase,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }
    ) {

        when (plantData) {
            is Resource.Error -> {
                Log.d("SearchTanamanScreen", "Error: ${plantData.message}")
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
                val plants = (plantData as Resource.Success<List<DataItem>>).data
                val filteredPlants = if (textSearch.isEmpty()) {
                    plants
                } else {
                    plants?.filter { plant ->
                        plant.namaTanaman?.lowercase()?.contains(textSearch.lowercase()) == true ||
                                plant.deskripsiTanaman?.lowercase()?.contains(textSearch.lowercase()) == true
                    }
                }

                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    items(filteredPlants!!.size) { index ->
                        filteredPlants[index].let { plant ->
                            SearchTanamanCard(
                                name = plant.namaTanaman ?: "Tidak ditemukan tanaman",
                                description = plant.deskripsiTanaman ?: "Tidak ditemukan deskripsi" ,
                                image = plant.fotoTanaman ?: "",
                                modifier = Modifier.clickable {
                                    val idTanaman = plant.idTanaman
                                    navController.navigate(Screen.DetailTanaman.route + "/$idTanaman")
                                }
                            )
                        }
                    }
                }

            }

            is Resource.Idle -> {
                // Do nothing
            }
        }


    }
}