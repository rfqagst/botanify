package com.example.botanify.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.presentation.ui.theme.ContentDark
import com.example.botanify.presentation.ui.theme.ContentWhite
import com.example.botanify.presentation.ui.theme.PrimaryBase
import com.example.botanify.presentation.ui.theme.PrimaryLight

@Composable
fun StandartBtn(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2EB24D),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}


@Composable
fun LargeBtn(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryBase,
            contentColor = ContentWhite
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(51.dp),
        shape = RoundedCornerShape(10.dp),
        enabled = enabled
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight(700),
            )
        )

    }
}

@Composable
fun SmallBtn(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryBase,
            contentColor = ContentWhite
        ),
        modifier = Modifier
            .height(30.dp)
            .wrapContentWidth()
        ,
        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
        )

    }
}


@Composable
fun FilterButton(modifier: Modifier, filterText: String, isActive: Boolean) {
    Box(
        modifier = modifier
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(if (isActive) PrimaryBase else PrimaryLight)

    ) {
        Text(
            modifier = Modifier.padding(6.dp),
            color = if (isActive) ContentWhite else ContentDark,
            text = filterText,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(600),
            )
        )
    }
}


@Preview
@Composable
private fun ButtonPrev() {
    Column(modifier = Modifier.fillMaxWidth()) {
//        SmallBtn(text = "Tambah") {
//        }
        LargeBtn(text = "Masuk", onClick = { /*TODO*/ }, modifier = Modifier)
    }
}