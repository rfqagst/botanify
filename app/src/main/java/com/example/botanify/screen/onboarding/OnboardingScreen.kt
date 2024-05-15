package com.example.botanify.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
<<<<<<< HEAD
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
=======
import androidx.navigation.NavHostController
>>>>>>> 5030b8d116aa998e30ce61eb0be4b622cb967772
import com.example.botanify.R
import com.example.botanify.screen.components.OnBoardingPage
import com.example.botanify.screen.components.OnBoardingPageTwo
import com.example.botanify.screen.components.PagerIndicator
import com.example.botanify.screen.components.StandartBtn
import com.example.botanify.screen.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
<<<<<<< HEAD
fun OnBoarding(
navController: NavController
) {

=======
fun OnBoardingScreen() {
>>>>>>> 5030b8d116aa998e30ce61eb0be4b622cb967772
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 22.dp)
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            2
        }
        TopAppBar(
            title = { /* Your title here */ },
            navigationIcon = {
                // Tombol back hanya ditampilkan saat halaman kedua aktif
                if (pagerState.currentPage == 1) {
                    IconButton(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage - 1
                            )
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            },
            // Alignment untuk tombol back di sebelah kiri
            modifier = Modifier.fillMaxWidth(),
        )

        Column(
            modifier = Modifier.height(580.dp)
        ) {
            HorizontalPager(state = pagerState) { index ->
                if (pagerState.currentPage == 0) {
                    OnBoardingPage(
                        page = Page(
                            title = "Pemindaian yang Cepat dan Akurat",
                            desc = "Kami menggunakan teknologi canggih untuk memberikan hasil yang akurat dengan cepat.",
                            image = R.drawable.on_boarding_1
                        )
                    )

                } else OnBoardingPageTwo(
                    page = Page(
                        title = "Ingatkan Perawatan Tanaman Anda",
                        desc = "Dengan fitur Reminder, Anda tidak akan pernah lagi melewatkan waktu penyiraman tanaman Anda.",
                        image = R.drawable.on_boarding_2
                    )
                )
            }
        }

        Spacer(modifier = Modifier.defaultMinSize(minHeight = 22.dp))

        PagerIndicator(
            pagesSize = pages.size,
            selectedPage = pagerState.currentPage,
            modifier = Modifier.padding(horizontal = 22.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier.padding(horizontal = 22.dp)
        ) {
<<<<<<< HEAD
            val buttonText = when (pagerState.currentPage) {
                0 -> "Selanjutnya"
                1 -> "Masuk"
                else -> ""
            }

            Spacer(modifier = Modifier .weight(1f))
            if (buttonText.isNotEmpty()) {
=======
            val buttonState = remember {
                derivedStateOf {
                    when (pagerState.currentPage) {
                        0 -> listOf("Selanjutnya")
                        1 -> listOf("Masuk")
                        else -> listOf("", "")
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))


            if (buttonState.value[0].isNotEmpty()) {
>>>>>>> 5030b8d116aa998e30ce61eb0be4b622cb967772
                StandartBtn(
                    text = buttonText,
                    onClick = {
<<<<<<< HEAD
                        if (pagerState.currentPage == 1) {
                            navController.navigate(Screen.Login.route)
                        } else {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
=======
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
>>>>>>> 5030b8d116aa998e30ce61eb0be4b622cb967772
                        }
                    }
                )
            } else {
                StandartBtn(text = buttonState.value[1], onClick = {
                })
            }
<<<<<<< HEAD
=======

>>>>>>> 5030b8d116aa998e30ce61eb0be4b622cb967772
        }

    }


}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPrev() {
<<<<<<< HEAD
    //OnBoarding()
=======
//    OnBoardingScreen()
>>>>>>> 5030b8d116aa998e30ce61eb0be4b622cb967772
}

