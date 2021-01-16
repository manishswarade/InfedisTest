package com.manishwarade.inf.data.book

data class News (

    var status : String = "",

    var totalResults : Int = 0,

    var articles : List<Article> = ArrayList()
)