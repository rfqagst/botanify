package com.example.botanify.notifikasi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.components.NotificationCard

@Composable
fun NotificationScreen(modifier: Modifier) {
    Column {
        NotificationCard(modifier = Modifier)
        NotificationCard(modifier = Modifier)
        NotificationCard(modifier = Modifier)
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewNotificationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        NotificationScreen(modifier = Modifier)
    }
}