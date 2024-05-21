package com.example.botanify.screen.tanamansaya

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.screen.components.TanamanSayaCard
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun ListTanamanSayaScreen(modifier: Modifier) {
    var showBottomSheet by remember { mutableStateOf(false) }

        Column(modifier = modifier
            .background(SurfaceBase)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(10) { tanaman ->
                    TanamanSayaCard(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clickable {
                                showBottomSheet = true
                            }
                    )
                }
            }

            if (showBottomSheet) {
                BottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    content = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)
                        ) {
                            DetailTanamanSayaScreen()
                        }
                    }
                )
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = rememberModalBottomSheetState(),
        containerColor = Color(0xFFFFFFFF),
        contentColor = MaterialTheme.colorScheme.onSurface,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        scrimColor = Color.Black.copy(alpha = 0.5f),
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTanamanSayaList() {
    ListTanamanSayaScreen(modifier = Modifier)
}