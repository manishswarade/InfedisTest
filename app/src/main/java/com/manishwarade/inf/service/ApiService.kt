package com.manishwarade.inf.service

import com.manishwarade.inf.data.book.BookBase
import com.manishwarade.inf.data.book.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=us&category=business&apiKey=c92b313dc37c4b9cbe294c04e3086152")
    fun getNews(): Call<News>

    @GET("https://www.googleapis.com/books/v1/volumes?q=0-7645-26413")
    fun getBooks(): Call<BookBase>
}