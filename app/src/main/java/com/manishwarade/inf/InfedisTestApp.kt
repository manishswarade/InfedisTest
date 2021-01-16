package com.manishwarade.inf

import android.app.Application
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class InfedisTestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        baseAppContext = applicationContext
    }



    companion object {

        lateinit var baseAppContext: Context
    }
}