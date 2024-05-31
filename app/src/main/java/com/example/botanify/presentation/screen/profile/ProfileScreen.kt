package com.example.botanify.presentation.screen.profile

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import com.example.botanify.R
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.screen.auth.AuthViewModel
import com.example.botanify.presentation.ui.theme.ContentDark
import com.example.botanify.presentation.ui.theme.ContentSemiDark
import com.example.botanify.presentation.ui.theme.SurfaceBase

@Composable
fun ProfileScreen(modifier: Modifier, authViewModel: AuthViewModel, navController: NavController) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)
    var showLogoutDialog by remember { mutableStateOf(false) }
    val currentUser = authViewModel.currentUser

    Column(
        modifier
            .fillMaxSize()
            .background(SurfaceBase)
            .padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo1),
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Nama",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = ContentDark,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = currentUser?.displayName ?: "",
            style = TextStyle(
                fontSize = 16.sp,
                color = ContentSemiDark,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Email",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = ContentDark,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = currentUser?.email ?: "",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = ContentSemiDark,

                )
        )
        Spacer(modifier = Modifier.height(16.dp))

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(51.dp)
                .background(color = Color(0xFFF9FAFB), shape = RoundedCornerShape(size = 8.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pengaturan",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                        fontWeight = FontWeight(700),
                        color = ContentDark,
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "",
                    tint = Color(0xFF7F8590),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        IconButton(
            onClick = { showLogoutDialog = true  },
            modifier = Modifier
                .fillMaxWidth()
                .height(51.dp)
                .background(color = Color(0xFFF9FAFB), shape = RoundedCornerShape(size = 8.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Keluar",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                        fontWeight = FontWeight(700),
                        color = ContentDark,
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "",
                    tint = Color(0xFF7F8590),
                    modifier = Modifier.padding(start = 20.dp)
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


@Composable
@Preview(showBackground = true)
fun PreviewProfile() {
    Column(modifier = Modifier.fillMaxSize()) {
//        ProfileScreen(modifier = Modifier)

    }

}

