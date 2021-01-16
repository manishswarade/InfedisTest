package com.manishwarade.inf.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manishwarade.inf.R
import com.manishwarade.inf.data.book.Article
import com.manishwarade.inf.helper.load
import kotlinx.android.synthetic.main.row_news.view.*

class NewsAdapter(private val context: Context): RecyclerView.Adapter<NewsAdapter.NewsViewHoler>() {

    private var items: List<Article> = ArrayList()

    var onGotoLinkClick = { _: String -> }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHoler {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_news, parent, false)

        return NewsViewHoler(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHoler, position: Int) {
        holder.bind(items.get(position))
    }



    fun setItems(data: List<Article>) {
        items = data
        notifyDataSetChanged()
    }

    inner class NewsViewHoler(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: Article) {

            if(!item.urlToImage.isNullOrEmpty())
                itemView.img_profile.load(item.urlToImage)

            itemView.text_author.setText("Author: ${item.author}")
            itemView.text_publish_date.setText("PublishedAt: ${item.publishedAt}")
            itemView.text_title.setText("Title: ${item.title}")
            itemView.text_description.setText("Description: ${item.description}")

            if(item.content.isNullOrEmpty()) {
                itemView.text_source.visibility = View.GONE
            }
            else {
                itemView.text_source.setText("Source: ${item.source.name}")
            }


            if(item.content.isNullOrEmpty()) {
                itemView.text_content.visibility = View.GONE
            }
            else {
                itemView.text_content.setText("Content: ${item.content}")
            }

            itemView.btn_go_to_link.setOnClickListener {
                onGotoLinkClick(item.url)
            }
        }
    }
}
