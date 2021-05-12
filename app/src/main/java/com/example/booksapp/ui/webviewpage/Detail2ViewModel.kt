package com.example.booksapp.ui.webviewpage

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Detail2ViewModel : ViewModel() {
    val urlLiveData = MutableLiveData<String>()

    fun handleIntent(extras: Bundle?) {
        urlLiveData.value = extras?.getString("key_website")
    }
}