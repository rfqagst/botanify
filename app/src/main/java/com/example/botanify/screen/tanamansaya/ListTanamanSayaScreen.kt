package com.example.botanify.screen.tanamansaya

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.botanify.data.local.informationData
import com.example.botanify.screen.components.InformationHomeCard
import com.example.botanify.screen.components.TanamanSayaCard
import com.example.botanify.screen.navigation.Screen

@Composable
fun ListTanamanSayaScreen(modifier: Modifier) {
    Column(modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp) // Padding around the entire list
        ) {
            items(10) { item ->
                TanamanSayaCard(
                    modifier = Modifier
                        .padding(bottom = 16.dp) // Padding between cards
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