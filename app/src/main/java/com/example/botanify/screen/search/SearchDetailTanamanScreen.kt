package com.example.botanify.screen.search

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.data.local.plantsData
import com.example.botanify.screen.components.ExpandableCard
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun DetailTanamanScreen(modifier: Modifier, tanamanId : String) {

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    val plantData = plantsData
    val plant = plantData.find { it.id == tanamanId }


    if(plant != null) {
        Column(
            modifier = modifier.background(SurfaceBase)
        ) {
            Image(
                modifier = Modifier
                    .height(216.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = plant.image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .background(ContentWhite)
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = plant.name,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 44.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            ExpandableCard(
                modifier = Modifier,
                cardTitle = "Keterangan",
                onClick = { expandedState = !expandedState },
                rotationState = rotationState,
                expandedState = expandedState,
                expadableValue = plant.description
            )
        }

    }



}

@Composable
@Preview(showBackground = true)
fun PreviewDetailTanaman() {
    Column(modifier = Modifier.fillMaxSize()) {
//        DetailTanamanScreen(modifier = Modifier)
    }

}