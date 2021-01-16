package com.manishwarade.inf.data.book

data class Items (

    val kind : String,
    val id : String,
    val etag : String,
    val selfLink : String,
    val volumeInfo : VolumeInfo,
    val saleInfo : SaleInfo,
    val accessInfo : AccessInfo,
    val searchInfo : SearchInfo
)