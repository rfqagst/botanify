//package com.example.botanify.presentation.screen.tanamansaya
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.FavoriteBorder
//import androidx.compose.material.icons.filled.KeyboardArrowDown
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.botanify.R
//import com.example.botanify.data.local.MyPlantData
//import com.example.botanify.data.local.myplantsData
//import com.example.botanify.data.model.PlantCollection
//import com.example.botanify.presentation.ui.theme.ContentSemiDark
//import com.example.botanify.presentation.ui.theme.Neutral60
//import com.example.botanify.presentation.ui.theme.SecondaryBase
//
//@Composable
//fun DetailTanamanSayaScreen(plant: PlantCollection) {
//    Column(
//        modifier = Modifier
//            .background(color = Color(0xFFFFFFFF))
//            .padding(16.dp)
//    ) {
//        Spacer(modifier = Modifier.height(16.dp))
//        Image(
//            painter = painterResource(id = plant.image),
//            contentDescription = "",
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(221.dp)
//                .clip(RoundedCornerShape(10.dp)),
//            contentScale = ContentScale.FillWidth
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = plant.name,
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    imageVector = Icons.Default.FavoriteBorder,
//                    tint = Color.Red,
//                    contentDescription = null
//                )
//            }
//        }
//        Text(
//            modifier = Modifier
//                .padding(bottom = 16.dp),
//            text = plant.description,
//            color = Color(0xFF141916),
//            style = TextStyle(
//                fontSize = 14.sp,
//                lineHeight = 24.sp,
//                fontWeight = FontWeight(400),
//            )
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(
//            text = "Penyiraman Selanjutnya :",
//            style = TextStyle(
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                tint = SecondaryBase,
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(30.dp),
//                painter = painterResource(id = R.drawable.ic_wateringcan),
//                contentDescription = null
//            )
//            Spacer(modifier = Modifier.width(5.dp))
//            Text(
//                text = plant.schedule,
//                color = Color(0xFF141916),
//                style = TextStyle(
//                    fontSize = 16.sp,
//                    lineHeight = 21.sp,
//                    fontWeight = FontWeight(600),
//                )
//            )
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}
//
//
