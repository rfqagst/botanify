package com.example.botanify.screen.informasi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.screen.components.InformationHomeCard
import com.example.botanify.screen.components.SearchBarTanaman

@Composable
fun ListInformasiScreen(modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        SearchBarTanaman(modifier = Modifier)
        Spacer(modifier = Modifier.height(24.dp))
        InformationHomeCard(modifier = Modifier)
        InformationHomeCard(modifier = Modifier)
        InformationHomeCard(modifier = Modifier)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewListInformasiScreen() {
    ListInformasiScreen(modifier = Modifier.padding(16.dp))
}