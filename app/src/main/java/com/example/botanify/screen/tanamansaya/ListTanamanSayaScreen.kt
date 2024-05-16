package com.example.botanify.screen.tanamansaya

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.screen.components.TanamanSayaCard
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun ListTanamanSayaScreen(modifier: Modifier) {
    Column(modifier = modifier.background(SurfaceBase).padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(10) { item ->
                TanamanSayaCard(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTanamanSayaList() {
    ListTanamanSayaScreen(modifier = Modifier)
}