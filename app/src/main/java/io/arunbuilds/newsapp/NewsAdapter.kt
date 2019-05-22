package io.arunbuilds.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.arunbuilds.newsapp.model.TopHeadlines.Article
import kotlinx.android.synthetic.main.news_item_layout.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    var news = emptyList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        bindItem(holder,position)
    }

    private fun bindItem(holder: NewsViewHolder, position: Int) {
        holder.newsTitle.text = news[position].title
        holder.newsDescription.text = news[position].description
      //  holder.newsPoster.setImageResource(GetImageResourceSomehow(news[position].urlToImage))
       // holder.newsTime.text = HumanReadableTime(news[position].publishedAt)
    }

    class NewsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val newsTitle = view.tvtitle
        val newsDescription = view.tvdescription
        val newsTime = view.tvTime
        val newsPoster = view.ivPoster
    }
}