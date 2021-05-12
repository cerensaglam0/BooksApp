package com.example.booksapp.ui.webviewpage


import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.databinding.ActivityDetail2Binding

class Detail2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDetail2Binding
    private lateinit var viewModel: Detail2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(Detail2ViewModel::class.java)
        viewModel.handleIntent(intent.extras)
        setUpWebView()
        setUpObserve()

    }

    private fun setUpObserve() {
        viewModel.urlLiveData.observe(this, Observer {
            binding.webViewDetail2Page.loadUrl(it)
        })
    }

    private fun setUpWebView() {
        with(binding.webViewDetail2Page) {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.progressBarDetail2Page.isVisible = true
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBarDetail2Page.isVisible = false
                }
            }
        }
    }


}







