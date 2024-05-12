package com.example.botanify.screen.notifikasi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.botanify.screen.components.NotificationCard

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