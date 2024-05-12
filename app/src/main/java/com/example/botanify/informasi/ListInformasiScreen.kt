package com.example.botanify.informasi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.components.InformationCard
import com.example.botanify.components.SearchBarTanaman

@Composable
fun ListInformasiScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        SearchBarTanaman(modifier = Modifier)
        Spacer(modifier = Modifier.height(24.dp))
        InformationCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        InformationCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        InformationCard(modifier = Modifier)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewListInformasiScreen() {
    ListInformasiScreen(modifier = Modifier.padding(16.dp))
}