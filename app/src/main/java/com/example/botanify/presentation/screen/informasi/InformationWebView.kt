package com.example.botanify.presentation.screen.informasi

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun InformationWebView(modifier : Modifier, webUrl : String) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            loadUrl(webUrl)
            webViewClient = WebViewClient()
        }
    }, update = {
        it.loadUrl(webUrl)
    })
}