package com.example.booksapp.data.response

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("result")
    val result: ArrayList<Book>?
)
