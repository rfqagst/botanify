package com.example.botanify.presentation.screen.tanamansaya

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.botanify.data.firebase.model.PlantCollection
import com.example.botanify.presentation.components.TanamanSayaCard
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.utils.Resource
import formatReminder
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun ListTanamanSayaScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: TanamanSayaViewModel
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedPlant by remember { mutableStateOf<PlantCollection?>(null) }
    var deletePlant by remember { mutableStateOf(false) }
    var plantToDelete by remember { mutableStateOf<Pair<String, PlantCollection>?>(null) }


    val listPlantState by viewModel.plantCollection.collectAsState()
    val deletePlantState by viewModel.deletePlantState.collectAsState()


    val delete = SwipeAction(
        onSwipe = {
            plantToDelete?.let {
                deletePlant = true
            }
        },
        icon = {
            Icon(
                imageVector = Icons.Default.Delete, contentDescription = "",
                tint = Color(0xFFBA1200),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(60.dp)
            )
        },
        background = Color.Transparent
    )

    Column(
        modifier = modifier
            .background(Color(0xFFEFEFEF))
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {

        when (listPlantState) {
            is Resource.Error -> {
                Log.d("ListInformasiScreen", "Error: ${listPlantState.message}")
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
                listPlantState.let {
                    val plants =
                        (listPlantState as Resource.Success<List<PlantCollection>>).data
                    Log.d("ListTanamanSayaScreen", "Plants: $plants")  // Tambahkan log ini

                    plants?.let {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(plants.size) { index ->
                                val plant = plants[index]
                                SwipeableActionsBox(
                                    endActions = listOf(delete.copy(onSwipe = {
                                        plantToDelete = plant.collectionId to plant
                                        deletePlant = true
                                    })),
                                    backgroundUntilSwipeThreshold = Color.Transparent,
                                    swipeThreshold = 200.dp
                                ) {
                                    TanamanSayaCard(
                                        modifier = Modifier
                                            .padding(bottom = 16.dp)
                                            .clickable {
                                                selectedPlant = plant
                                                showBottomSheet = true
                                            },
                                        title = plant.plantName,
                                        image = plant.plantImage,
                                        schedule = formatReminder(plant.reminder)
                                    )

                                }

                            }
                        }
                    }
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
        FloatingActionButton(
            onClick = { navController.navigate(Screen.TambahKoleksiTanaman.route) },
            containerColor = Color(0xFF2BB34B),
            contentColor = Color.White,
            shape = CircleShape
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }

    }


    if (deletePlant && plantToDelete != null) {
        AlertDialog(
            onDismissRequest = { deletePlant = false },
            title = { Text(text = "Konfirmasi Hapus") },
            text = { Text(text = "Apakah Anda yakin ingin menghapus tanaman ini?") },
            confirmButton = {
                Button(
                    onClick = {
                        val userId = viewModel.currentUser?.uid ?: return@Button
                        viewModel.deletePlantCollection(userId, plantToDelete!!.first)
                        deletePlant = false
                    }
                ) {
                    Text("Ya")
                }
            },
            dismissButton = {
                Button(onClick = { deletePlant = false }) {
                    Text("Tidak")
                }
            }
        )
    }

    when (deletePlantState) {
        is Resource.Success -> {
            Log.d("ListTanamanSayaScreen", "Plant deleted successfully")
            deletePlant = false
            plantToDelete = null
        }
        is Resource.Error -> {
            Log.d("ListTanamanSayaScreen", "Error deleting plant: ${deletePlantState.message}")
            deletePlant = false
        }
        is Resource.Loading -> {
            // Show loading indicator if necessary
        }
        is Resource.Idle -> {
            // do nothing
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismissRequest: () -> Unit,
    plant: PlantCollection
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
