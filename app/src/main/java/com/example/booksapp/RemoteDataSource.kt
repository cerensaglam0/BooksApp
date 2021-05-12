package com.example.booksapp

import com.example.booksapp.data.api.ApiUtils
import com.example.booksapp.data.response.BookResponse
import io.reactivex.Observable

class RemoteDataSource {
    fun getBook(): Observable<BookResponse> {
        return ApiUtils.getApiService().getBook()
    }
}