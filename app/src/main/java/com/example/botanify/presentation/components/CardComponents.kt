package com.example.botanify.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.botanify.R
import com.example.botanify.presentation.navigation.Screen
import com.example.botanify.presentation.ui.theme.ContentDark
import com.example.botanify.presentation.ui.theme.ContentLightBlue
import com.example.botanify.presentation.ui.theme.ContentSemiDark
import com.example.botanify.presentation.ui.theme.ContentWhite
import com.example.botanify.presentation.ui.theme.PrimaryBase
import com.example.botanify.presentation.ui.theme.SecondaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase

@Composable
fun BannerCard(modifier: Modifier, navController: NavHostController) {

    Row(
        modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(ContentLightBlue),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Tambah Koleksi \nTanaman mu",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            SmallBtn(modifier = Modifier, text = "Tambah", onClick = {
                navController.navigate(Screen.TambahKoleksiTanaman.route)
            })
        }
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.banner_plant1),
            contentDescription = null
        )
    }

}


@Composable
fun InformationHomeCard(modifier: Modifier, title: String, date: String, image: String) {
    Row(
        modifier = modifier
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(ContentWhite)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .width(60.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ContentLightBlue)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = ContentDark,
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    tint = SecondaryBase,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.ic_calender),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = date,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                    )
                )
            }
        }

    }

}

@Composable
fun TanamankuHomeCard(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(135.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(10.dp, 10.dp))
                .background(ContentLightBlue)

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.card_plant1),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .width(135.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
                .background(ContentWhite),

            ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = "Pink Philodendron",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Row(
                modifier = Modifier.padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    tint = SecondaryBase,

                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    painter = painterResource(id = R.drawable.ic_wateringcan),
                    contentDescription = null
                )
                Text(
                    text = "Rab, 8 Mei",
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 15.sp,
                        fontWeight = FontWeight(500),
                    )
                )
            }
        }

    }
}


@Composable
fun NotificationCard(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(bottom = 8.dp)
            .background(ContentWhite)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    tint = SecondaryBase,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Penyiraman Tanaman",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    tint = SecondaryBase,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.ic_wateringcan),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "09.30",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(600),
                    )
                )

            }
        }

        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = "Lakukan Penyiraman untuk tanaman : ",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            text = "Pink Philodendron ",
            color = PrimaryBase,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(600),
            )
        )
    }
}

@Composable
fun InformationCard(modifier: Modifier) {
    Column(
        modifier = modifier
            .height(115.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row {
            Image(
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp),
                painter = painterResource(id = R.drawable.information_plant1),
                contentDescription = null
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Monstera",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                        fontWeight = FontWeight(700),
                    )
                )
                Text(
                    text = "Tips merawat tanaman Monstera Deliciosa ...",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
    }
}

@Composable
fun TanamanSayaCard(modifier: Modifier, title: String, image: String, schedule: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(ContentWhite),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            modifier = Modifier
                .padding(8.dp)
                .width(75.dp)
                .height(96.dp)
                .clip(RoundedCornerShape(15.dp)),
            painter = rememberAsyncImagePainter(model = image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text(
                text = title,
                color = ContentDark,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Penyiraman Selanjutnya :",
                color = ContentSemiDark,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(400),
                )
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    tint = SecondaryBase,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.ic_wateringcan),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = schedule,
                    color = ContentSemiDark,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(600),
                    )
                )
            }
        }
    }
}

@Composable
fun SearchBarTanaman(modifier: Modifier) {
    Row(
        modifier = modifier
            .height(45.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(SurfaceBase),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            tint = SecondaryBase,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .width(24.dp)
                .height(24.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null
        )
        Text(
            text = "Cari tanaman",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
            )
        )
    }
}


@Composable
fun ExpandableCard(
    modifier: Modifier,
    cardTitle: String,
    onClick: () -> Unit,
    rotationState: Float,
    expandedState: Boolean,
    expadableValue: String
) {

    Column(
        modifier = modifier.background(ContentWhite)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = cardTitle,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 44.sp,
                    fontWeight = FontWeight(700),
                )
            )
            IconButton(
                modifier = Modifier.rotate(rotationState),
                onClick = onClick
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    tint = SecondaryBase,
                    contentDescription = null
                )
            }
        }

        if (expandedState) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                text = expadableValue,
                color = ContentSemiDark,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                )
            )
        }
    }
}

@Composable
fun SearchTanamanCard(modifier: Modifier, name: String, description: String, image: String) {
    Row(
        modifier = modifier
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(ContentWhite)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .width(60.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ContentLightBlue)
        ) {


            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = rememberAsyncImagePainter(model = image),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(600),
                    color = ContentDark,
                )
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                text = description,
                color = ContentSemiDark,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

            }
        }

    }
}


@Composable
fun SearchInformationCard(modifier: Modifier, name: String, description: String, image: Int) {
    Row(
        modifier = modifier
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(ContentWhite)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .width(60.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ContentLightBlue)
        ) {

//            AsyncImage(
//                model = image, contentDescription = null, contentScale = ContentScale.Crop,
//            )

            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(600),
                    color = ContentDark,
                )
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                text = description,
                color = ContentSemiDark,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

            }
        }

    }
}


@Composable
@Preview(showBackground = true)
fun PreviewCardComponents() {

    Column(
        modifier = Modifier
            .background(SurfaceBase)
            .padding(16.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally

    ) {
//        SearchTanamanCard(modifier = Modifier)
//        BannerCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
//        FilterCard(modifier = Modifier, "Tips & Trick")
        Spacer(modifier = Modifier.height(16.dp))
//        InformationHomeCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        TanamankuHomeCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        NotificationCard(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        InformationCard(modifier = Modifier)
        SearchBarTanaman(modifier = Modifier)
    }
}