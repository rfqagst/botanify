package com.example.botanify.presentation.screen.scan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.botanify.presentation.components.LargeBtn
import com.example.botanify.presentation.ui.theme.ContentDark

@Composable
fun InstruksiScanScreen(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Snap Tips",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = ContentDark
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(81.dp))
        Box(
            modifier = Modifier.size(160.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.plantdata_flamingo),
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.ic_checkmark),
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.TopEnd),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Benar",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = ContentDark
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Row {
            Column {
                Box(
                    modifier = Modifier.width(110.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plantdata_krisan),
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_xmark),
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.TopEnd),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Terlalu Dekat",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = ContentDark
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(end = 17.dp)
                )
            }

            Column {
                Box(
                    modifier = Modifier.width(110.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plantdata_palem),
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_xmark),
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.TopEnd),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Terlalu Jauh",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = ContentDark
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(end = 17.dp)
                )
            }
            Column {
                Box(
                    modifier = Modifier.width(110.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plantdata_dracaena),
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_xmark),
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.TopEnd),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Banyak Jenis",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = ContentDark
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(end = 7.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(101.dp))
        LargeBtn(text = "Lanjutkan", onClick = { /*TODO*/ }, modifier = Modifier)


    }

}


@Composable
@Preview(showBackground = true)
fun PreviewInstruksiScanScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        InstruksiScanScreen(modifier = Modifier)

    }

}