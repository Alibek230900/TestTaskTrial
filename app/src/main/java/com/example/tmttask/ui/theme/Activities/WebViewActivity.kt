package com.example.tmttask.ui.theme.Activities

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.tmttask.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView: WebView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true


        val websites = listOf("kaspi.kz","kolesa.kz")

        val randomwebsite = websites.random()
        webView.loadUrl(randomwebsite)
    }
}