package com.example.botanify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.ContentLightBlue
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun BannerCard(modifier: Modifier) {

    Row(
        modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(ContentLightBlue),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Tambah Koleksi \nTanaman mu",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                )
            )
        }
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.banner_plant1),
            contentDescription = null
        )
    }

}

@Composable
fun FilterCard(modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(PrimaryBase)
    ) {
        Text(
            modifier = Modifier.padding(6.dp),
            color = ContentWhite,
            text = "Tips & Trick",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(600),
            )
        )
    }
}

@Composable
fun InformationHomeCard(modifier: Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(ContentWhite)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .width(60.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ContentLightBlue)
        ) {
            Image(
                painter = painterResource(id = R.drawable.card_plant1),
                contentDescription = null
            )
        }

        Column {
            Text(
                text = "Tips menjaga kelembapan ruangan",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(600),
                    color = ContentDark,
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.ic_calender),
                    contentDescription = null
                )
                Text(
                    text = "Senin, 24 Maret 2024",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                    )
                )
            }
        }
    }
}

@Composable
fun TanamankuHomeCard(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(135.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(10.dp,10.dp,))
                .background(ContentLightBlue)

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.card_plant1),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .width(135.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
                .background(ContentWhite),

            ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = "Pink Philodendron",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Row(
                modifier = Modifier.padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    painter = painterResource(id = R.drawable.ic_wateringcan),
                    contentDescription = null
                )
                Text(
                    text = "Rab, 8 Mei",
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 15.sp,
                        fontWeight = FontWeight(500),
                    )
                )
            }
        }

    }
}


@Composable
@Preview(showBackground = true)
fun PreviewCardComponents() {

    Column(
        modifier = Modifier
            .background(SurfaceBase)
            .padding(16.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        BannerCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        FilterCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        InformationHomeCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        TanamankuHomeCard(modifier = Modifier)
    }
}