package com.example.botanify.screen.scan

import android.net.Uri
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.botanify.R
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.ContentWhite

@Composable
fun ScanTanamanScreen(modifier: Modifier, navController: NavHostController) {
    val applicationContext = LocalContext.current
    val controller = remember {
        LifecycleCameraController(applicationContext).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE)
        }
    }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var instruksi by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.15f),
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
                        if (selectedImageUri != null) {
                            navController.navigate(Screen.HasilScan.route)
                        } else navController.navigate(Screen.HasilScan.route)
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
                            if (instruksi != null){
                                navController.navigate(Screen.InstruksiScan.route)
                            } else navController.navigate(Screen.InstruksiScan.route)
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


}



