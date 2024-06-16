package com.example.botanify.presentation.screen.scan

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.presentation.components.ExpandableCard
import com.example.botanify.presentation.components.SmallBtn
import com.example.botanify.utils.Resource


@Composable
fun HasilScanScreen(modifier: Modifier, penanggananViewModel: PenanggananViewModel) {

    var expandedStateKeterangan by remember { mutableStateOf(false) }
    var expandedStateDiagnosa by remember { mutableStateOf(false) }
    var expandedStatePenanganan by remember { mutableStateOf(false) }

    val rotationStateKeterangan by animateFloatAsState(
        targetValue = if (expandedStateKeterangan) 180f else 0f, label = ""
    )
    val rotationStateDiagnosa by animateFloatAsState(
        targetValue = if (expandedStateDiagnosa) 180f else 0f, label = ""
    )
    val rotationStatePenanganan by animateFloatAsState(
        targetValue = if (expandedStatePenanganan) 180f else 0f, label = ""
    )

    val context = LocalContext.current

    val penanggananPenyakitState by penanggananViewModel.penanggananPenyakitState.collectAsState()
    val penanggananHamaState by penanggananViewModel.penanggananHamaState.collectAsState()


    LaunchedEffect(key1 = String) {
//        penanggananViewModel.getPenaggananPenyakit("powdery mildew")
        penanggananViewModel.getPenaggananHama("caterpillar")

    }

    when (penanggananHamaState) {
        is Resource.Error -> {
            //
        }

        is Resource.Idle -> {
            //
        }

        is Resource.Loading -> {
            //
        }

        is Resource.Success -> {
            val data = (penanggananHamaState as Resource.Success).data
            data?.forEach { item ->
                Log.d(
                    "HasilScanHama",
                    "ID Penanganan: ${item.idPenanganan}, Nama Hama: ${item.namaHama}, Penanganan: ${item.penanganan}"
                )
            }
        }
    }

    Column(modifier = modifier.padding(horizontal = 16.dp)) {
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
                    text = "Tambah Ke Koleksi Tanaman",
                    onClick = {
                        Toast.makeText(
                            context,
                            "Berhasil Menambah Tanaman Ke Koleksi",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Keterangan",
            onClick = {
                expandedStateKeterangan = !expandedStateKeterangan
            },
            rotationState = rotationStateKeterangan,
            expandedState = expandedStateKeterangan,
            expadableValue = "Aglaonema, juga dikenal sebagai \"Chinese Evergreen\", adalah tanaman hias dengan daun tebal, hijau gelap, dan motif daun yang menarik. Beberapa varietas memiliki warna daun yang beragam, termasuk hijau, merah muda, putih, atau perak."
        )

        Spacer(modifier = Modifier.height(16.dp))
        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Hasil Diagnosa",
            onClick = {
                expandedStateDiagnosa = !expandedStateDiagnosa
            },
            rotationState = rotationStateDiagnosa,
            expandedState = expandedStateDiagnosa,
            expadableValue = "Nama Penyakit: Penyakit Embun Tepung\nHama: Jamur Erysiphales."
        )

        Spacer(modifier = Modifier.height(16.dp))
        ExpandableCard(
            modifier = Modifier,
            cardTitle = "Penanganan",
            onClick = {
                expandedStatePenanganan = !expandedStatePenanganan
            },
            rotationState = rotationStatePenanganan,
            expandedState = expandedStatePenanganan,
            expadableValue = "Memastikan sirkulasi udara yang baik di sekitar tanaman, menghindari kelembaban berlebih, dan menggunakan fungisida yang sesuai dapat membantu mengendalikan penyakit ini."
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewHasilScan() {
    Column(modifier = Modifier.fillMaxSize()) {
//        HasilScanScreen(modifier = Modifier)

    }

}

