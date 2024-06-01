package com.example.botanify.presentation.screen.informasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.botanify.data.local.informationData
import com.example.botanify.presentation.ui.theme.ContentDark
import com.example.botanify.presentation.ui.theme.ContentSemiDark
import com.example.botanify.presentation.ui.theme.PrimaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase

@Composable
fun DetailInformasiScreen(modifier: Modifier, informationId : String) {

    val informationData = informationData
    val information = informationData.find { it.id == informationId }


    if(information != null) {
        Column(
            modifier
                .background(SurfaceBase)
                .verticalScroll(rememberScrollState())) {
            Image(
                modifier = Modifier
                    .height(216.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = information.image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = information.title,
                    color = ContentDark,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = information.publisher,
                    color = PrimaryBase,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = information.date,
                    color = ContentSemiDark,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = information.description,
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



}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailInformasiScreenPreview() {
//    DetailInformasiScreen(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
}


