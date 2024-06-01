package com.example.botanify.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.botanify.presentation.ui.theme.ContentSemiDark
import com.example.botanify.presentation.ui.theme.Neutral60
import com.example.botanify.presentation.ui.theme.PrimaryBase


@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagesSize: Int,
    selectedPage: Int,
    selectedColor: Color = Color(0xFF2EB24D),
    unselectedColor: Color =  Color(0xFFA6A8A6),
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        repeat(pagesSize){
            IndicatorSingleDot(isSelected = it == selectedPage )
        }


    }
}

@Composable
fun IndicatorSingleDot(isSelected: Boolean,
                       selectedColor: Color = Color(0xFF2EB24D),
                       unselectedColor: Color =  Color(0xFFA6A8A6)
) {
    val width = animateDpAsState(targetValue = if (isSelected) 45.dp else 15.dp, label = "")
    Box(modifier = Modifier
        .padding(2.dp)
        .height(10.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(if (isSelected) PrimaryBase else Neutral60)
    )
}
