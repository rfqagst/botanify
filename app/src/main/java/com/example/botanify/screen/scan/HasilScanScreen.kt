package com.example.botanify.screen.scan

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import com.example.botanify.R
import com.example.botanify.screen.components.ExpandableCard
import com.example.botanify.screen.components.SmallBtn
import com.example.botanify.screen.profile.ProfileScreen
import com.example.botanify.ui.theme.ContentDark
import com.example.botanify.ui.theme.ContentSemiDark
import com.example.botanify.ui.theme.ContentWhite

@Composable
fun HasilScanScreen(modifier: Modifier) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.scantnm),
            contentDescription = "",
            modifier = Modifier
                .width(326.dp)
                .height(221.dp)
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally), // Center the image horizontally
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(114.dp)) {
            Image(
                painter = painterResource(id = R.drawable.tanamansaya_plant1),
                contentDescription = "",
                modifier
                    .width(98.dp)
                    .height(114.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Aglaonema",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W600,
                            color = ContentSemiDark,
                        ),
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    SmallBtn(
                        text = "Tambah Ke Koleksi",
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(202.dp)
                            .height(40.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Keterangan",
            onClick = { /*TODO*/ },
            rotationState = rotationState,
            expandedState = expandedState,
            expadableValue = "Aglaonema, juga dikenal sebagai \"Chinese Evergreen\", adalah tanaman hias dengan daun tebal, hijau gelap, dan motif daun yang menarik. Beberapa varietas memiliki warna daun yang beragam, termasuk hijau, merah muda, putih, atau perak."
        )
        Spacer(modifier = Modifier.height(16.dp))
        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Hasil Diagnosa",
            onClick = { /*TODO*/ },
            rotationState = rotationState,
            expandedState = expandedState,
            expadableValue = "Nama Penyakit: Penyakit Embun Tepung\n" +
                    "Hama: Jamur Erysiphales."
        )
        Spacer(modifier = Modifier.height(16.dp))
        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Penanganan",
            onClick = { /*TODO*/ },
            rotationState = rotationState,
            expandedState = expandedState,
            expadableValue = "Memastikan sirkulasi udara yang baik di sekitar tanaman, menghindari kelembaban berlebih, dan menggunakan fungisida yang sesuai dapat membantu mengendalikan penyakit ini."
        )
    }
}
@Composable
@Preview(showBackground = true)
fun PreviewHasilScan() {
    Column(modifier = Modifier.fillMaxSize()) {
        HasilScanScreen(modifier = Modifier)

    }

}
