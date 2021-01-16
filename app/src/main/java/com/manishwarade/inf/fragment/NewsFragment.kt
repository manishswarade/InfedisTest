package com.manishwarade.inf.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manishwarade.inf.R
import com.manishwarade.inf.adapter.NewsAdapter
import com.manishwarade.inf.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.content_vertical_recycler.*


class NewsFragment: Fragment() {

    private lateinit var newsViewModel: NewsViewModel

    lateinit var adapter: NewsAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.content_vertical_recycler, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        initUi()

        handleEvent()

        newsViewModel.findNews()
    }

    private fun initUi() {

        progress.visibility = View.VISIBLE

        adapter = NewsAdapter(context!!)

        recycler.adapter = adapter

        recycler.setHasFixedSize(true)

        adapter.onGotoLinkClick = fun(link : String) {
            openBrowserToBrowseLink(link)
        }
    }


    private fun handleEvent() {

        newsViewModel.news.observe(this, Observer {

            progress.visibility = View.GONE

            if(it.status.equals("ok")) {
                adapter.setItems(it.articles)
            }
            else {
                Toast.makeText(context, "Error when reading news. Please try after some times.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun openBrowserToBrowseLink(link : String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }
}