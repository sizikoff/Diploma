package com.example.diploma.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.diploma.MyWebViewClient
import com.example.diploma.R

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_web_view)

        webView = findViewById<WebView?>(R.id.webview).apply {
            setWebViewClient(MyWebViewClient())
            getSettings().javaScriptEnabled = true
            loadUrl("https://dis-group.ru/")
        }
    }

    @Deprecated("Deprecated in Java")
    @Suppress("DeprecatedCallableAddReplaceWith", "RedundantSuppression","DEPRECATION")
    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}