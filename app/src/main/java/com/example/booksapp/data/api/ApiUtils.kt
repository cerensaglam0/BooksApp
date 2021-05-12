package com.example.booksapp.data.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    private const val BASE_URL = "https://api.collectapi.com/book/"
    private var retrofit: Retrofit? = null

    fun getApiService(): BooksApiService {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit!!.create(BooksApiService::class.java)
    }

}
