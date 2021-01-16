package com.manishwarade.inf.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manishwarade.inf.R
import com.manishwarade.inf.data.book.Items
import com.manishwarade.inf.helper.load
import kotlinx.android.synthetic.main.row_books.view.*
import android.annotation.SuppressLint as SuppressLint1

class BooksAdapter: RecyclerView.Adapter<BooksAdapter.NewsViewHoler>() {

    private var items: List<Items> = ArrayList()

    var onGotoLinkClick = { _: String -> }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHoler {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_books, parent, false)

        return NewsViewHoler(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint1("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHoler, position: Int) {
        holder.bind(items.get(position))
    }



    fun setItems(data: List<Items>) {
        items = data
        notifyDataSetChanged()
    }

    inner class NewsViewHoler(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: Items) {

            if(item.volumeInfo.imageLinks.thumbnail.isNullOrEmpty()) {
                itemView.img_book.load(item.volumeInfo.imageLinks.smallThumbnail)
            }
            else {
                itemView.img_book.load(item.volumeInfo.imageLinks.thumbnail)
            }

            itemView.text_title.setText(item.volumeInfo.title)

            if(item.volumeInfo.subtitle.isNullOrEmpty()) {
                itemView.text_subtitle.visibility = View.GONE
            }
            else {
                itemView.text_subtitle.setText("Sub Title: ${item.volumeInfo.subtitle}")
            }

            itemView.text_author.setText("by ${item.volumeInfo.authors.joinToString { it }}")


            if(item.volumeInfo.description.isNullOrEmpty()) {
                itemView.text_description.visibility = View.GONE
            }
            else {
                itemView.text_description.setText("Description: ${item.volumeInfo.description}")
            }



            itemView.text_page_count.setText("Page Count: ${item.volumeInfo.pageCount}")

            itemView.text_print_type.setText("Print Type: ${item.volumeInfo.printType}")

            if(item.volumeInfo.averageRating.isNullOrEmpty()) {
                itemView.text_rating.visibility = View.GONE
            }
            else {
                itemView.text_rating.setText("Average Rating: ${item.volumeInfo.averageRating}")
            }


            itemView.btn_preview_link.setOnClickListener {
                onGotoLinkClick(item.volumeInfo.previewLink)
            }

            itemView.btn_chronical_volume.setOnClickListener {
                onGotoLinkClick(item.volumeInfo.canonicalVolumeLink)
            }

            itemView.btn_info_linfo.setOnClickListener {
                onGotoLinkClick(item.volumeInfo.infoLink)
            }
        }
    }
}
