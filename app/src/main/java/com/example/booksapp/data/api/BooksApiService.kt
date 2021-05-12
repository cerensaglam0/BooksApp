package com.example.booksapp.data.api

import com.example.booksapp.data.response.BookResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface BooksApiService {

    @Headers(
        "content-type: application/json",
        "authorization: apikey 1LeKEUhIJ09SGb7X8PAP1Q:4LW1F7HE3qV28DaGoCngZm"
    )

    @GET("newBook")
    fun getBook(): Observable<BookResponse>
}