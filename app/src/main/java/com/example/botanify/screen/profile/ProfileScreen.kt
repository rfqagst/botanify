package com.example.botanify.screen.profile

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.decode.ImageSource
import com.example.botanify.R
import com.example.botanify.screen.auth.AuthViewModel
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.ContentSemiDark
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun ProfileScreen(modifier: Modifier, authViewModel: AuthViewModel, navController: NavController) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)
    var showLogoutDialog by remember { mutableStateOf(false) }
    val currentUser = authViewModel.currentUser

    Box(
        modifier
            .fillMaxSize()
            .background(SurfaceBase)
    ) {
        Column(
            modifier = Modifier
                .height(340.dp)
                .fillMaxWidth()
                .background(color = PrimaryBase)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_photo1),
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(160.dp)
                    .clip(CircleShape),
                contentDescription = "Profile Image",
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = currentUser?.displayName ?: "Guest",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = currentUser?.email ?: "Guest",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                )
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
            contentAlignment = Alignment.Center){
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color(0xFFFFFFFF))
                    .padding(start = 10.dp, end = 10.dp)){
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(51.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Edit,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(end = 20.dp))
                            Text(
                                text = "Edit Profile",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = ContentDark,
                                ),
                                modifier = Modifier.weight(1f)
                            )

                        }

                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(51.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Lock,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(end = 20.dp))
                            Text(
                                text = "Ganti Kata Sandi",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = ContentDark,
                                ),
                                modifier = Modifier.weight(1f)
                            )

                        }

                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(51.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Delete,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(end = 20.dp))
                            Text(
                                text = "Hapus Akun",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = ContentDark,
                                ),
                                modifier = Modifier.weight(1f)
                            )

                        }

                    }
                    IconButton(
                        onClick = { showLogoutDialog = true  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(51.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Logout,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(end = 20.dp))
                            Text(
                                text = "Keluar",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = ContentDark,
                                ),
                                modifier = Modifier.weight(1f)
                            )

                        }

                    }


                    if (showLogoutDialog) {
                        AlertDialog(
                            onDismissRequest = { showLogoutDialog = false },
                            title = { Text(text = "Konfirmasi Logout") },
                            text = { Text(text = "Apakah Anda yakin ingin logout?") },
                            confirmButton = {
                                Button(
                                    onClick = {
                                        showLogoutDialog = false
                                        authViewModel.logout()
                                        navController.navigate(Screen.Login.route)
                                    }
                                ) {
                                    Text("Ya")
                                }
                            },
                            dismissButton = {
                                Button(
                                    onClick = { showLogoutDialog = false }
                                ) {
                                    Text("Tidak")
                                }
                            }
                        )
                    }

                }
            }

        }
        }

    



    }


@Composable
@Preview(showBackground = true)
fun PreviewProfile() {
    Column(modifier = Modifier.fillMaxSize()) {
//        ProfileScreen(modifier = Modifier)

    }

}

