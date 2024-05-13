package com.example.botanify.screen.informasi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.botanify.data.local.informationData
import com.example.botanify.screen.components.InformationHomeCard
import com.example.botanify.screen.components.SearchBarTanaman
import com.example.botanify.screen.navigation.Screen

@Composable
fun ListInformasiScreen(modifier: Modifier, navController: NavHostController) {
    val informationData = informationData

    Column(modifier = modifier.padding(16.dp)) {
        SearchBarTanaman(modifier = Modifier.clickable { navController.navigate(Screen.Search.route) })
        Spacer(modifier = Modifier.height(24.dp))
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewListInformasiScreen() {
//    ListInformasiScreen(modifier = Modifier.padding(16.dp))
}