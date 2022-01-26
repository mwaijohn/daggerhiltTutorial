package com.example.daggertuts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggertuts.model.Article

class DataAdapter(private val context: Context): RecyclerView.Adapter<DataAdapter.ItemViewHolder>() {

    private var items: List<Article> = emptyList()

    inner class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.news_item, parent, false)) {

        private var title: TextView = itemView.findViewById(R.id.title)
        private var datePublished: TextView = itemView.findViewById(R.id.published_time)
        private var featureImage: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(article: Article) {
            title.text = article.title
            datePublished.text  = article.publishedAt
            Glide.with(featureImage.context).load(article.urlToImage).into(featureImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(context)
        return ItemViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val status: Article = items[position]
        holder.bind(status)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(articles  : List<Article>){
        items = articles
        notifyDataSetChanged()
    }
}