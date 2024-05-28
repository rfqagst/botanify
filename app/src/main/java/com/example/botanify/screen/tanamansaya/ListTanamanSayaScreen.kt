package com.example.botanify.screen.tanamansaya

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.botanify.data.local.MyPlantData
import com.example.botanify.data.local.myplantsData
import com.example.botanify.screen.components.TanamanSayaCard
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.SurfaceBase

@SuppressLint("SuspiciousIndentation")
@Composable
fun ListTanamanSayaScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedPlant by remember { mutableStateOf<MyPlantData?>(null) }
    val myPlantData = myplantsData

    Column(
        modifier = modifier
            .background(Color(0xFFEFEFEF))
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(myPlantData.size) { index ->
                myPlantData[index].let { plant ->
                    TanamanSayaCard(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clickable {
                                selectedPlant = plant
                                showBottomSheet = true
                            },
                        title = plant.name,
                        image = plant.image,
                        schedule = plant.schedule
                    )
                }
            }
        }

        if (showBottomSheet && selectedPlant != null) {
            BottomSheet(
                onDismissRequest = { showBottomSheet = false },
                plant = selectedPlant!!
            )
        }

    }
    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(onClick = { navController.navigate(Screen.TambahKoleksiTanaman.route) },
            containerColor = Color(0xFF2BB34B),
            contentColor = Color.White,
            shape = CircleShape) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismissRequest: () -> Unit,
    plant: MyPlantData
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = rememberModalBottomSheetState(),
        containerColor = Color(0xFFFFFFFF),
        contentColor = MaterialTheme.colorScheme.onSurface,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        scrimColor = Color.Black.copy(alpha = 0.5f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DetailTanamanSayaScreen(plant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTanamanSayaList() {
    //ListTanamanSayaScreen(modifier = Modifier, navController = )
}