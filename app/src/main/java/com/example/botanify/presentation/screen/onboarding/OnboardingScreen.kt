package com.example.botanify.presentation.screen.onboarding

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.R
import com.example.botanify.data.datastore.OnboardingManager
import com.example.botanify.presentation.components.OnBoardingPage
import com.example.botanify.presentation.components.OnBoardingPageTwo
import com.example.botanify.presentation.components.PagerIndicator
import com.example.botanify.presentation.components.StandartBtn

import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnBoarding(
    onboardingManager: OnboardingManager,
    onFinish:  () -> Unit
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0) { 2 }
    val isOnboardingCompleted by onboardingManager.isOnboardingCompleted.collectAsState(initial = false)

    // Jika onboarding sudah selesai, panggil onFinish dan kembali
    if (isOnboardingCompleted) {
        LaunchedEffect(Unit) {
            onFinish()
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 22.dp)
    ) {
        TopAppBar(
            title = { /* Your title here */ },
            navigationIcon = {
                if (pagerState.currentPage == 1) {
                    IconButton(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage - 1
                            )
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Column(
            modifier = Modifier.height(580.dp)
        ) {
            HorizontalPager(state = pagerState) { page ->
                if (page == 0) {
                    OnBoardingPage(
                        page = Page(
                            title = "Pemindaian yang Cepat dan Akurat",
                            desc = "Kami menggunakan teknologi canggih untuk memberikan hasil yang akurat dengan cepat.",
                            image = R.drawable.on_boarding_1
                        )
                    )
                } else {
                    OnBoardingPageTwo(
                        page = Page(
                            title = "Ingatkan Perawatan Tanaman Anda",
                            desc = "Dengan fitur Reminder, Anda tidak akan pernah lagi melewatkan waktu penyiraman tanaman Anda.",
                            image = R.drawable.on_boarding_2
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.defaultMinSize(minHeight = 22.dp))

        PagerIndicator(
            pagesSize = 2,
            selectedPage = pagerState.currentPage,
            modifier = Modifier.padding(horizontal = 22.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier.padding(horizontal = 22.dp)
        ) {
            val buttonText = when (pagerState.currentPage) {
                0 -> "Selanjutnya"
                1 -> "Masuk"
                else -> ""
            }

            Spacer(modifier = Modifier.weight(1f))

            StandartBtn(
                text = buttonText,
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage == pages.size - 1) {

                          onboardingManager.setOnboardingCompleted(true)
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                })

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPrev() {
    // Provide a fake NavController for preview purposes
    // OnBoarding(navController = rememberNavController())
}
