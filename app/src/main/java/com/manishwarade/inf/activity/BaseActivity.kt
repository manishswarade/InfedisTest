package com.manishwarade.inf.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.manishwarade.inf.R
import com.manishwarade.inf.helper.NetworkUtils

open class BaseActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null

    fun mergeToolbar() {

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        setSupportActionBar(toolbar)

        toolbar!!.setNavigationIcon(R.drawable.ic_baseline_arrow_white_24)

        toolbar!!.setNavigationOnClickListener { onBackPressed() }
    }

    private fun showInternetNotConnected() {

        show(this, "No Internet", "You are not connected to the internet. Please check you Wi-Fi or data connectivity") {
            finish()
        }
    }

    fun show(context: Context, title: String, message: String, action: () -> Unit) {

        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Ok"
            ) { d, n -> action()
            }
            .show()
    }

    fun checkInternet(): Boolean {

        return if(!NetworkUtils.isConnected()) {
            showInternetNotConnected()
            false
        }
        else true
    }
}