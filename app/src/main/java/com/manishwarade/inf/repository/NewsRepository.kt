package com.manishwarade.inf.repository

import com.manishwarade.inf.data.book.BookBase
import com.manishwarade.inf.data.book.News
import com.manishwarade.inf.helper.RetrofitBuilder

object NewsRepository {

    fun getNews(): News? {

        val news = RetrofitBuilder.apiService.getNews()

        val response = news.execute()

        return response.body()
    }

    fun getBooks(): BookBase? {
        val news = RetrofitBuilder.apiService.getBooks()

        val response = news.execute()

        return response.body()
    }
}