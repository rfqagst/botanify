package com.example.botanify.presentation.screen.informasi

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun InformationWebView(modifier : Modifier) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            loadUrl("https://rfqagst.github.io/tips-menanam-bunga-matahari.html")
            webViewClient = WebViewClient()
        }
    }, update = {
        it.loadUrl("https://rfqagst.github.io/tips-menanam-bunga-matahari.html")
    })
}