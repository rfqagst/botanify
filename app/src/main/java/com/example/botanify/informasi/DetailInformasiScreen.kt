package com.example.botanify.informasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.ContentSemiDark
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.SecondaryBase

@Composable
fun DetailInformasiScreen(modifier: Modifier) {
    Column() {
        Image(
            modifier = Modifier
                .height(216.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.information_photo1),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = modifier,
        ) {
            Text(
                text = "7 Tips Merawat Tanaman Hias Supaya Tumbuh Sehat dan Kuat di Rumah",
                color = ContentDark,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Danica Adhitiawarman - detikProperti",
                color = PrimaryBase,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(400),
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Senin, 29 Apr 2024 07:30 WIB",
                color = ContentSemiDark,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Jakarta - Tanaman hias yang ditaruh di dalam rumah sangat bergantung pada pemiliknya untuk bisa bertahan hidup. Maka, kalau ingin tanaman hias tumbuh optimal, kamu perlu memberi perhatian lebih supaya kebutuhan tanaman terpenuhi.",
                color = ContentSemiDark,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                )
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailInformasiScreenPreview() {
    DetailInformasiScreen(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
}


