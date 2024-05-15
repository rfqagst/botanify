package com.example.botanify.screen.registrasi


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.botanify.R
import com.example.botanify.screen.components.IconTextField
import com.example.botanify.screen.components.LargeBtn
import com.example.botanify.screen.components.PasswordtTextField
import com.example.botanify.screen.navigation.NavGraph
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.BotanifyTheme
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.Neutral60
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.PrimaryLight
import com.example.botanify.ui.theme.SurfaceBase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController : NavController) {
    TopAppBar(
        title = {
            "Registrasi"

        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp, vertical = 30.dp)
    ) {
        var rememberMe by remember { mutableStateOf(false) }
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Registrasi",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 44.sp,
                //fontFamily = FontFamily(Font(R.font.plus jakarta sans)),
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
                //fontFamily = FontFamily(Font(R.font.plus jakarta sans)),
                fontWeight = FontWeight(500),
                color = Neutral60,

                )
        )
        Spacer(modifier = Modifier.height(22.dp))
        IconTextField(modifier = Modifier, titleTextField = "Nama Anda", iconTextField = painterResource(
            id =  R.drawable.ic_person_input))
        Spacer(modifier = Modifier.height(22.dp))
        IconTextField(modifier = Modifier, titleTextField = "Email", iconTextField = painterResource(
            id =  R.drawable.ic_email))
        Spacer(modifier = Modifier.height(16.dp))
        PasswordtTextField(modifier = Modifier, titleTextField = "Password", iconTextField = painterResource(
            id = R.drawable.ic_lock))
        Spacer(modifier = Modifier.height(16.dp))
        PasswordtTextField(modifier = Modifier, titleTextField = "Konfirmasi Password", iconTextField = painterResource(
            id = R.drawable.ic_lock))
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                modifier = Modifier
                    .padding(0.dp)
                    .offset(-12.dp),
                checked = rememberMe,
                onCheckedChange = { rememberMe = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = PrimaryBase,
                    checkmarkColor = SurfaceBase
                ),



                )

            Text(
                text = "Ingat Saya",
                modifier = Modifier
                    .weight(1f)
                    .offset(x = -16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    //fontFamily = FontFamily(Font(R.font.dm sans)),
                    fontWeight = FontWeight(500),
                    color = ContentDark,

                    )
            )


            //Text(text = "Lupa Password?", modifier = Modifier.weight(1f), textAlign = TextAlign.Right )
        }
        Spacer(modifier = Modifier.height(32.dp))
        LargeBtn(text = "Daftar", onClick = { navController.navigate(Screen.Login.route) }, modifier = Modifier)
        Spacer(modifier = Modifier.height(24.dp))



    }
}