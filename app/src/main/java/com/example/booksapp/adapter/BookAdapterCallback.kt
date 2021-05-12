package com.example.booksapp.adapter

import com.example.booksapp.data.response.Book

interface BookAdapterCallback {
    fun onBookItemClick(book: Book)
}