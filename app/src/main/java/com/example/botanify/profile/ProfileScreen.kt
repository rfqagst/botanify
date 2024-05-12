package com.example.botanify.profile

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.components.ExpandableCard
import com.example.botanify.informasi.DetailInformasiScreen

@Composable
fun ProfileScreen(modifier: Modifier){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)
    Column(modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo1),
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Nama",
            modifier.padding(start = 20.dp, top = 66.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
            )
        )
        Text(
            text = "Rifqy Barusadar",
            modifier.padding(start = 20.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color(0xFF7F8590),

                )
        )
        Text(
            text = "Email",
            modifier.padding(start = 20.dp, top = 34.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
            )
        )
        Text(
            text = "GgG@gmail.com",
            modifier.padding(start = 20.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color(0xFF7F8590),

                )
        )
        Spacer(modifier = Modifier.height(26.dp))
        IconButton(
            onClick = { /*TODO*/ } ,
            modifier = Modifier
                .fillMaxWidth()
                .height(51.dp)
                .background(color = Color(0xFFF9FAFB), shape = RoundedCornerShape(size = 8.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pengaturan",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF7F8590),
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "",
                    tint = Color(0xFF7F8590),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

        }


    }
}

@Composable
@Preview(showBackground = true)
fun PreviewProfile() {
    Column(modifier = Modifier.fillMaxSize()) {
        ProfileScreen(modifier = Modifier)

    }

}

