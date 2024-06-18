package com.example.botanify.presentation.screen.scan

import android.content.Context
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.botanify.data.retrofit.response.scan.Penangganan
import com.example.botanify.presentation.components.ExpandableCard
import com.example.botanify.presentation.components.ExpandableCardScan
import com.example.botanify.presentation.components.SmallBtn


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

    val uiState by penanggananViewModel.penanggananState.collectAsState()

    val scrollState = rememberScrollState()


    LaunchedEffect(Unit) {
        penanggananViewModel.getPenangganan("caterpillar", "powdery mildew")
    }


    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        HasilScanContent(
            expandedStateKeterangan,
            onExpandKeterangan = { expandedStateKeterangan = !expandedStateKeterangan },
            expandedStateDiagnosa,
            onExpandDiagnosa = { expandedStateDiagnosa = !expandedStateDiagnosa },
            expandedStatePenanganan,
            onExpandPenanganan = { expandedStatePenanganan = !expandedStatePenanganan },
            rotationStateKeterangan,
            rotationStateDiagnosa,
            rotationStatePenanganan,
            uiState = uiState ?: PenanggananUiState.Loading,
        )

    }
}


@Composable
fun HasilScanContent(
    expandedStateKeterangan: Boolean,
    onExpandKeterangan: () -> Unit,
    expandedStateDiagnosa: Boolean,
    onExpandDiagnosa: () -> Unit,
    expandedStatePenanganan: Boolean,
    onExpandPenanganan: () -> Unit,
    rotationStateKeterangan: Float,
    rotationStateDiagnosa: Float,
    rotationStatePenanganan: Float,
    uiState: PenanggananUiState,
) {
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
                text = "Agloenema",
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

                },
                modifier = Modifier
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    when (uiState) {
        is PenanggananUiState.Loading -> {
            Text(text = "Loading...")
        }
        is PenanggananUiState.Success -> {
            PlantDetail(
                expandedStateKeterangan = expandedStateKeterangan,
                onExpandKeterangan = onExpandKeterangan,
                expandedStateDiagnosa = expandedStateDiagnosa,
                onExpandDiagnosa = onExpandDiagnosa,
                expandedStatePenanganan = expandedStatePenanganan,
                onExpandPenanganan = onExpandPenanganan,
                rotationStateKeterangan = rotationStateKeterangan,
                rotationStateDiagnosa = rotationStateDiagnosa,
                rotationStatePenanganan = rotationStatePenanganan,
                penangganan = uiState.penangganan
            )
        }
        is PenanggananUiState.Error -> {
            Text(text = "Error loading data")
        }
    }
}

@Composable
fun PlantDetail(
    expandedStateKeterangan: Boolean,
    onExpandKeterangan: () -> Unit,
    expandedStateDiagnosa: Boolean,
    onExpandDiagnosa: () -> Unit,
    expandedStatePenanganan: Boolean,
    onExpandPenanganan: () -> Unit,
    rotationStateKeterangan: Float,
    rotationStateDiagnosa: Float,
    rotationStatePenanganan: Float,
    penangganan: Penangganan
) {
    ExpandableCard(
        modifier = Modifier,
        cardTitle = "Keterangan",
        onClick = onExpandKeterangan,
        rotationState = rotationStateKeterangan,
        expandedState = expandedStateKeterangan,
        expadableValue = "Aglaonema, juga dikenal sebagai \"Chinese Evergreen\", adalah tanaman hias dengan daun tebal, hijau gelap, dan motif daun yang menarik. Beberapa varietas memiliki warna daun yang beragam, termasuk hijau, merah muda, putih, atau perak."
    )

    Spacer(modifier = Modifier.height(16.dp))
    ExpandableCardScan(
        modifier = Modifier,
        cardTitle = "Hasil Diagnosa",
        onClick = onExpandDiagnosa,
        rotationState = rotationStateDiagnosa,
        expandedState = expandedStateDiagnosa,
        penyakitValue = "Nama Penyakit: ${penangganan.namaPenyakit.uppercase()}",
        hamaValue = "Nama Hama: ${penangganan.namaHama.uppercase()}"
    )

    Spacer(modifier = Modifier.height(16.dp))
    ExpandableCardScan(
        modifier = Modifier,
        cardTitle = "Penanganan",
        onClick = onExpandPenanganan,
        rotationState = rotationStatePenanganan,
        expandedState = expandedStatePenanganan,
        penyakitValue = "Penanganan Penyakit: ${penangganan.penanggananPenyakit}",
        hamaValue = "Penanganan Hama: ${penangganan.penanggananHama}"
    )
}


@Composable
@Preview(showBackground = true)
fun PreviewHasilScan() {
    Column(modifier = Modifier.fillMaxSize()) {
//        HasilScanScreen(modifier = Modifier)

    }

}

