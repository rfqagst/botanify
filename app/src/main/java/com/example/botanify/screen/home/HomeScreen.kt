package com.example.botanify.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.screen.components.BannerCard
import com.example.botanify.screen.components.FilterCard
import com.example.botanify.screen.components.InformationHomeCard
import com.example.botanify.screen.components.SearchBarTanaman
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.SecondaryBase

@Composable
fun HomeScreen(modifier: Modifier) {
    Column() {
        Column(modifier = Modifier.background(ContentWhite)) {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(180.dp))
                            .width(50.dp)
                            .height(50.dp),
                        painter = painterResource(id = R.drawable.profile_photo1),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Bonjour,",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 22.sp,
                                fontWeight = FontWeight(400),
                                fontStyle = FontStyle.Italic,
                            )
                        )
                        Text(
                            text = "Rifqi Barusadar",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 22.sp,
                                fontWeight = FontWeight(500),
                            )
                        )
                    }
                }
                Icon(
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null, tint = SecondaryBase
                )
            }
            SearchBarTanaman(modifier = Modifier.padding(16.dp))

        }


        Spacer(modifier = Modifier.height(4.dp))


        Column(modifier = Modifier.padding(16.dp)) {
            BannerCard(modifier = Modifier)
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Informasi Tanaman",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Pelajari lebih lanjut tentang tanaman",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(400),
                        )
                    )
                }
                Text(
                    text = "Lihat semua",
                    color = SecondaryBase,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row {
                FilterCard(modifier = Modifier, "Tips & Trick")
                FilterCard(modifier = Modifier, "Penyakit")
                FilterCard(modifier = Modifier, "Hama")
            }
            Spacer(modifier = Modifier.height(16.dp))
            InformationHomeCard(modifier = Modifier)
            InformationHomeCard(modifier = Modifier)
            InformationHomeCard(modifier = Modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        modifier = Modifier
            .padding(16.dp)
    )
}