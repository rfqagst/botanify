package com.example.botanify.screen.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.botanify.R
import com.example.botanify.data.model.Plant
import com.example.botanify.screen.components.SearchTanamanCard
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.SecondaryBase
import com.example.botanify.ui.theme.SurfaceBase
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

        when(plantData) {
            is Resource.Error -> {
                Log.d("SearchTanamanScreen", "Error: ${plantData.message}")
            }
            is Resource.Loading -> {
                CircularProgressIndicator()
            }
            is Resource.Success -> {
                val plants = (plantData as Resource.Success<List<Plant>>).data
                val filteredPlants = if (textSearch.isEmpty()) {
                    plants
                } else {
                    plants?.filter { plant ->
                        plant.name.lowercase().contains(textSearch.lowercase()) ||
                                plant.description.lowercase().contains(textSearch.lowercase())
                    }
                }

                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    items(filteredPlants!!.size) { index ->
                        filteredPlants[index].let { plant ->
                            SearchTanamanCard(
                                name = plant.name,
                                description = plant.description,
                                image = plant.image,
                                modifier = Modifier.clickable {
                                    val tanamanId = plant.id
                                    navController.navigate(Screen.DetailTanaman.route + "/$tanamanId")
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
//
//        val filteredPlants = if (textSearch.isEmpty()) {
//            plantsData
//        } else {
//            plantsData.filter { plant ->
//                plant.name.lowercase().contains(textSearch.lowercase()) ||
//                        plant.description.lowercase().contains(textSearch.lowercase())
//            }
//        }


    }
}