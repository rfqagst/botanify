package com.example.botanify.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.presentation.screen.onboarding.Page
import com.example.botanify.presentation.ui.theme.BotanifyTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            //.fillMaxHeight(0.60f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .width(282.dp)
                .height(74.dp),
            text = page.title,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),

                )
        )
        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = page.desc,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF6B7280),

                )
        )
    }
}

@Composable
fun OnBoardingPageTwo(
    modifier: Modifier = Modifier,
    page: Page,
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .width(282.dp)
                .height(74.dp),
            text = page.title,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),

                )
        )
        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = page.desc,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF6B7280),

                )
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview() {
    BotanifyTheme {
        OnBoardingPageTwo(
            page = Page(
                title = "Ingatkan Perawatan Tanaman Anda",
                desc = "Dengan fitur Reminder, Anda tidak akan pernah lagi melewatkan waktu penyiraman tanaman Anda.",
                image = R.drawable.on_boarding_2
            )
        )
    }
}