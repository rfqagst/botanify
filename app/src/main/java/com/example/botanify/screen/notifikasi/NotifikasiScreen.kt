package com.example.botanify.screen.notifikasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.screen.components.NotificationCard
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun NotificationScreen(modifier: Modifier) {
    Column(modifier.fillMaxSize().background(SurfaceBase).padding(top= 16.dp)) {
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