package com.example.botanify.presentation.screen.informasi

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.utils.Resource

@Composable
fun DetailInformasiScreen(
    modifier: Modifier,
    informationId: String,
    informationViewModel: InformationViewModel
) {

    val informationDetail by informationViewModel.informationById.collectAsState(initial = null)


    LaunchedEffect(informationId) {
        informationViewModel.fetchInformationById(informationId)
    }

    when (informationDetail) {
        is Resource.Error -> {
            Log.d("DetailTanamanScreen", "Error: ${(informationDetail as Resource.Error).message}")
        }

        is Resource.Idle -> {
            // do nothing
        }

        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 36.dp)
                        .size(48.dp)
                )
            }
        }

        is Resource.Success -> {
            val information = (informationDetail as Resource.Success).data
            information?.let {
                InformationWebView(modifier = modifier, webUrl = information.url)

            }

        }

        null -> {
            // do nothing
        }
    }



}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailInformasiScreenPreview() {
//    DetailInformasiScreen(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
}


