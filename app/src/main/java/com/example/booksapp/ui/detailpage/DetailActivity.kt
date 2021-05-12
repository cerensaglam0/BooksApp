package com.example.booksapp.ui.detailpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.booksapp.R
import com.example.booksapp.data.response.Book
import com.example.booksapp.databinding.ActivityDetailBinding
import com.example.booksapp.ui.webviewpage.Detail2Activity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val book = intent.getParcelableExtra<Book>("key_book")
        binding.book=book


        binding.textViewWebView.setOnClickListener {
            val intent=Intent(this, Detail2Activity::class.java)
            intent.putExtra("key_website", book?.url)
            startActivity(intent)
        }
    }


}