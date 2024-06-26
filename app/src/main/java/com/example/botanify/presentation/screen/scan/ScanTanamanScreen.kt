package com.example.botanify.presentation.screen.scan

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.botanify.R
import com.example.botanify.data.retrofit.response.scan.ScanResult
import com.example.botanify.data.retrofit.response.scan.gson
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.ui.theme.ContentWhite
import com.example.botanify.utils.toFile
import java.net.URLEncoder

@Composable
fun ScanTanamanScreen(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: ScanViewModel
) {
    val applicationContext = LocalContext.current
    val selectedImageUri by viewModel.selectedImageUri.collectAsState()

    val scanState by viewModel.scanState.collectAsState()

    val controller = remember {
        LifecycleCameraController(applicationContext).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE)
        }
    }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                viewModel.selectedImageUri(uri)
            }
        }

    Column(modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(0.85f)
                .fillMaxWidth()
        ) {
            if (selectedImageUri != null) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberAsyncImagePainter(model = selectedImageUri),
                    contentDescription = null,
                )
                Log.d("SelectedScanHasil", "selectedImageUriSScan: $selectedImageUri")
            } else {
                CameraPreview(controller = controller, modifier = Modifier.fillMaxSize())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(modifier = Modifier,
                        onClick = { navController.popBackStack() }) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }

                    IconButton(modifier = Modifier,
                        onClick = {
                            controller.cameraSelector =
                                if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                    CameraSelector.DEFAULT_FRONT_CAMERA
                                } else {
                                    CameraSelector.DEFAULT_BACK_CAMERA
                                }
                        }) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            imageVector = Icons.Default.Cameraswitch,
                            contentDescription = null,
                            tint = ContentWhite
                        )
                    }

                }
            }
        }

        CameraBottomMenu(
            modifier = Modifier.weight(0.15f),
            launcher = launcher,
            selectedImageUri = selectedImageUri,
            navController = navController,
            viewModel = viewModel,
            applicationContext = applicationContext
        )


        when (scanState) {
            is ScanState.Error -> {
                Log.d("ScanTanamanScreen", "Error: ${(scanState as ScanState.Error).message}")
            }

            is ScanState.Idle -> {
                //
            }

            is ScanState.LoadingIdentifyPlantDiseases -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(top = 36.dp)
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sedang Mengenali Nama Tanaman",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            is ScanState.LoadingIdentifyPlantName -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(top = 36.dp)
                                .size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sedang Mendiagnosis Penyakit/Hama Tanaman",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            is ScanState.ScanResult -> {

                val scanResult = (scanState as ScanState.ScanResult)
                val sharedPlantDetail = ScanResult(
                    plantName = scanResult.plantName,
                    disease = scanResult.disease,
                    userImageUri = Uri.encode(scanResult.userImageUri)
                )

                Log.d("ScanTanamanScreen", "Scan Result: ${scanResult.userImageUri}")

                val jsonString = URLEncoder.encode(gson.toJson(sharedPlantDetail), "UTF-8")
                Log.d("JsonStringggss", "Scan Result: $jsonString")

                navController.navigate(Screen.HasilScan.route + "/$jsonString")

            }

        }


    }
}


@Composable
fun CameraBottomMenu(
    modifier: Modifier,
    launcher: ManagedActivityResultLauncher<String, Uri?>,
    selectedImageUri: Uri?,
    navController: NavHostController,
    viewModel: ScanViewModel,
    applicationContext: Context
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        launcher.launch("image/*")
                    },
                painter = painterResource(id = R.drawable.ic_galleryblack),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Gallery",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                )
            )
        }


        Image(
            modifier = Modifier
                .size(68.dp)
                .clickable {
                    selectedImageUri
                        ?.toFile(applicationContext)
                        ?.let { file ->
                            viewModel.scanPlant(file)
                        }

                },
            painter = if (selectedImageUri != null) painterResource(id = R.drawable.ic_checkcircle) else painterResource(
                id = R.drawable.ic_scan2
            ),
            contentDescription = null
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        navController.navigate(Screen.InstruksiScan.route)
                    },
                painter = painterResource(id = R.drawable.ic_instruksi),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Instruksi",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                )
            )
        }

    }
}



