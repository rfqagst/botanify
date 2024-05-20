package com.example.botanify.screen.scan

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.botanify.screen.components.ExpandableCard
import com.example.botanify.screen.components.SmallBtn

@Composable
fun HasilScanScreen(modifier: Modifier) {
    var expandedState by remember { mutableStateOf(true) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = ""
    )

    Column(

    ) {
        Column(modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.scantnm),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(221.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.scantnm),
                    contentDescription = null,
                    modifier = Modifier
                        .size(114.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(24.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Aglaonema",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            fontWeight = FontWeight(700),
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SmallBtn(
                        text = "Tambah Koleksi Tanaman",
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        
        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Keterangan",
            onClick = { expandedState = !expandedState },
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

