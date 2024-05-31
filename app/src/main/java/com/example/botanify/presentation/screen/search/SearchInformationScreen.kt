package com.example.botanify.presentation.screen.search

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import com.example.botanify.R
import com.example.botanify.data.local.informationData
import com.example.botanify.presentation.components.SearchInformationCard
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.ui.theme.SecondaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInformationScreen(modifier: Modifier, navController: NavHostController) {


    var textSearch by remember {
        mutableStateOf("")
    }

    var activeSearch by remember {
        mutableStateOf(true)
    }

    SearchBar(
        modifier = modifier,
        colors = SearchBarDefaults.colors(SurfaceBase),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = "Cara Menanam Bunga Anggrek",
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
        val filteredInformation = if (textSearch.isEmpty()) {
            informationData
        } else {
            informationData.filter { information ->
                information.title.lowercase().contains(textSearch.lowercase()) ||
                        information.description.lowercase().contains(textSearch.lowercase())
            }
        }

        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(filteredInformation.size) { index ->
                filteredInformation[index].let { information ->
                    SearchInformationCard(
                        name = information.title,
                        description = information.description,
                        image = information.image,
                        modifier = Modifier.clickable {
                            val informationId = information.id
                            navController.navigate(Screen.DetailInformation.route + "/$informationId")
                        }
                    )
                }


            }
        }
    }
}