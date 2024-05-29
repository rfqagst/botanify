package com.example.botanify.screen.auth.register


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.botanify.R
import com.example.botanify.screen.auth.AuthViewModel
import com.example.botanify.screen.components.IconTextField
import com.example.botanify.screen.components.LargeBtn
import com.example.botanify.screen.components.PasswordtTextField
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.Neutral60
import com.example.botanify.ui.theme.SurfaceBase
import com.example.botanify.utils.Resource


@Composable
fun RegisterScreen(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    val signupFlow = authViewModel.signupFlow.collectAsState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SurfaceBase)
            .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {

        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Registrasi",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 44.sp,
                fontWeight = FontWeight(700),
                color = ContentDark,

                )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Segera daftarkan diri anda ke aplikasi! ",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight(500),
                color = Neutral60,

                )
        )
        Spacer(modifier = Modifier.height(22.dp))
        IconTextField(
            modifier = Modifier,
            titleTextField = "Nama Anda",
            iconTextField = painterResource(
                id = R.drawable.ic_person_input
            ),
            value = name,
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.height(22.dp))
        IconTextField(
            modifier = Modifier,
            titleTextField = "Email",
            iconTextField = painterResource(
                id = R.drawable.ic_email
            ),
            value = email,
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordtTextField(
            modifier = Modifier,
            titleTextField = "Password",
            iconTextField = painterResource(
                id = R.drawable.ic_lock
            ),
            value = password,
            onValueChange = { password = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordtTextField(
            modifier = Modifier,
            titleTextField = "Konfirmasi Password",
            iconTextField = painterResource(
                id = R.drawable.ic_lock
            ),
            value = confirmpassword,
            onValueChange = { confirmpassword = it }
        )
        Spacer(modifier = Modifier.height(16.dp))


        Spacer(modifier = Modifier.height(32.dp))

        LargeBtn(
            text = "Daftar",
            onClick = {
                Log.d("RegisterScreen", "Name: $name, Email: $email, Password: $password")
                authViewModel.signUp(name, email, password)
                Toast.makeText(context, "Berhasil Daftar Akun", Toast.LENGTH_LONG).show()
                navController.navigate(Screen.Login.route)
            },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(24.dp))


    }

    signupFlow.value.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }

            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            }

            null -> { /* Do nothing */
            }

            is Resource.Idle -> {
                // Do nothing
            }
        }
    }
}
