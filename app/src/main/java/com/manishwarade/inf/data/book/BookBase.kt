package com.manishwarade.inf.data.book

data class BookBase (

	val kind : String,
	val totalItems : Int,
	val items : List<Items>
)