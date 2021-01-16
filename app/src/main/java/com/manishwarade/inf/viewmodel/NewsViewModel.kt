package com.manishwarade.inf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manishwarade.inf.data.book.BookBase
import com.manishwarade.inf.data.book.News
import com.manishwarade.inf.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel : ViewModel() {


    var news : MutableLiveData<News> = MutableLiveData()

    var books : MutableLiveData<BookBase> = MutableLiveData()



    fun findNews() {

        viewModelScope.launch(IO) {

            val ne = NewsRepository.getNews()

            withContext(Dispatchers.Main) {

                ne?.let {
                    news.value = it
                }
            }
        }
    }

    fun findBooks() {

        viewModelScope.launch(IO) {

            val ne = NewsRepository.getBooks()

            withContext(Dispatchers.Main) {

                ne?.let {
                    books.value = it
                }
            }
        }
    }
}