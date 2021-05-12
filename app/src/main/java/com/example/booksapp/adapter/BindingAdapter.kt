package com.example.booksapp.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {       //Glide.with(this).load(URL).into(ImageView)
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}