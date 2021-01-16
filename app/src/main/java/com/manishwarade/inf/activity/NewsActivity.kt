package com.manishwarade.inf.activity

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.manishwarade.inf.R
import com.manishwarade.inf.adapter.NewsFragmentStateAdapter
import com.manishwarade.inf.fragment.BooksFragment
import com.manishwarade.inf.fragment.NewsFragment
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity() {

    lateinit var adapter: NewsFragmentStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        mergeToolbar()
        initewsFragmentStateAdapter()
        checkInternet()
    }

    private fun initewsFragmentStateAdapter() {

        val tabNames = arrayOf("News", "Books")

        val fragments = arrayOf(NewsFragment(), BooksFragment())


        adapter = NewsFragmentStateAdapter(supportFragmentManager, tabNames, fragments, tabNames.size)

        pager.adapter = adapter

        tabLayout.setupWithViewPager(pager)

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        tabLayout.tabMode = TabLayout.MODE_FIXED
    }
}