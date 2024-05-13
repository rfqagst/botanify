package com.example.botanify.screen.search

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.botanify.R
import com.example.botanify.data.local.plantsData
import com.example.botanify.screen.components.SearchTanamanCard
import com.example.botanify.ui.theme.SecondaryBase
import com.example.botanify.ui.theme.SurfaceBase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(modifier: Modifier) {

    val plantData = plantsData


    var textSearch by remember {
        mutableStateOf("")
    }

    var activeSearch by remember {
        mutableStateOf(true)
    }

    SearchBar(
        modifier = Modifier,
        colors = SearchBarDefaults.colors(SurfaceBase),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = "Cari Tanaman",
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
        val filteredPlants = if (textSearch.isEmpty()) {
            plantsData
        } else {
            plantsData.filter { plant ->
                plant.name.lowercase().contains(textSearch.lowercase()) ||
                        plant.description.lowercase().contains(textSearch.lowercase())
            }
        }

        LazyColumn(modifier = modifier.padding(16.dp)) {
            items(filteredPlants.size) { index ->
                filteredPlants[index].let { plant ->
                    SearchTanamanCard(
                        name = plant.name,
                        description = plant.description,
                        image = plant.image,
                        modifier = Modifier
                    )
                }


            }
        }
    }
}