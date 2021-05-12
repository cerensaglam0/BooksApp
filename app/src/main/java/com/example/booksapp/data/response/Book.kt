package com.example.booksapp.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    @SerializedName("url")
    val url: String?,
    @SerializedName("indirim")
    val sale: String?,
    @SerializedName("fiyat")
    val price: String?,
    @SerializedName("yayın")
    val broadcasting: String?,
    @SerializedName("yazar")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("image")
    val image: String?
) : Parcelable