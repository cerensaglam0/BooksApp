package com.example.booksapp

import com.example.booksapp.data.response.BookResponse
import io.reactivex.Observable

class Repository {
    private val remoteDataSource = RemoteDataSource()

    fun getBook(): Observable<BookResponse> {
        return remoteDataSource.getBook()
    }
}