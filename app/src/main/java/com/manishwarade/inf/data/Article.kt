package com.manishwarade.inf.data.book

data class Article (

    var source : Source = Source(),

    var author : String = "",

    var title : String = "",

    var description : String = "",

    var url : String = "",

    var urlToImage : String = "",

    var publishedAt : String = "",

    var content : String = ""
)