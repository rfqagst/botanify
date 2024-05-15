package com.example.botanify.screen.login

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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavHostController
import com.example.botanify.R
import com.example.botanify.screen.components.IconTextField
import com.example.botanify.screen.components.LargeBtn
import com.example.botanify.screen.components.PasswordtTextField
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.ui.theme.BotanifyTheme
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.Neutral60
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.PrimaryLight
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp, vertical = 30.dp)
    ) {
        var rememberMe by remember { mutableStateOf(false) }
        Text(
            text = "Masuk",
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
            text = "Selamat datang kembali!",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                //fontFamily = FontFamily(Font(R.font.plus jakarta sans)),
                fontWeight = FontWeight(500),
                color = Neutral60,

                )
        )
        Spacer(modifier = Modifier.height(22.dp))
        IconTextField(modifier = Modifier, titleTextField = "Email", iconTextField = painterResource(
            id =  R.drawable.ic_person_input))
        Spacer(modifier = Modifier.height(16.dp))
        PasswordtTextField(modifier = Modifier, titleTextField = "Password", iconTextField = painterResource(
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
            ClickableText(
                text = AnnotatedString("Lupa Password?"),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    //fontFamily = FontFamily(Font(R.font.plus jakarta sans)),
                    fontWeight = FontWeight(500),
                    color = Neutral60,
                    textAlign = TextAlign.Right,
                ),


                ) {

            }

        //Text(text = "Lupa Password?", modifier = Modifier.weight(1f), textAlign = TextAlign.Right )
        }
        Spacer(modifier = Modifier.height(32.dp))
        LargeBtn(text = "Masuk", onClick = { /*TODO*/ }, modifier = Modifier)
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Atau",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    //fontFamily = FontFamily(Font(R.font.plus jakarta sans)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9CA3AF),

                    ),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "",
                modifier = Modifier
                    .padding(1.dp)
                    .width(41.dp)
                    .height(42.dp)
                    .clickable { }
                    .background(PrimaryLight, shape = RoundedCornerShape(30.dp))
                    .clip(shape = CircleShape)
                )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "",
                modifier = Modifier
                    .padding(1.dp)
                    .width(41.dp)
                    .height(42.dp)
                    .clickable { }
                    .background(PrimaryLight, shape = RoundedCornerShape(30.dp))
                    .clip(shape = CircleShape)
            )
        }
        Spacer(modifier = Modifier .defaultMinSize(minHeight = 100.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum punya akun?",
                //fontFamily = Plus_Jakarta_Sans,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                color = Color(0xFF696B76)
            )
            Spacer(modifier = Modifier.width(2.dp))
            ClickableText(
                modifier = Modifier.padding(top = 2.dp),
                text = AnnotatedString("Daftar"),
                onClick = {
                    // Navigasi ke halaman berikutnya
                    // Misalnya:
                    // navController.navigate("next_page_route")
                },
                style = TextStyle(
                    //fontFamily = Plus_Jakarta_Sans,
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,

                    color = Color(0xFF696B76),

                    )
            )
        }


    }
}



@Preview(showBackground = true)
@Composable
private fun LoginScreenPrev() {
    BotanifyTheme {
//        LoginScreen()
    }
}