package com.manishwarade.inf.helper

import androidx.appcompat.widget.AppCompatImageView
import com.manishwarade.inf.R
import com.squareup.picasso.Picasso

fun AppCompatImageView.load(link: String) {

    Picasso.get().load(link)
        .error(R.drawable.image_not_found)
        .fit()
        .into(this)
}