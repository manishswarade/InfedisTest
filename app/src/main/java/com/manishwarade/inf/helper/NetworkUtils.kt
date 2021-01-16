package com.manishwarade.inf.helper

import android.content.Context
import android.net.ConnectivityManager
import com.manishwarade.inf.InfedisTestApp.Companion.baseAppContext

object NetworkUtils {

    fun isConnected(): Boolean {

        try {

            val cm = baseAppContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo

            return activeNetwork != null && activeNetwork.isConnected

        } catch (e: Exception) { /* */
            return false
        }
    }
}