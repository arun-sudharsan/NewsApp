package io.arunbuilds.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.arunbuilds.newsapp.network.NewsApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dividerItemDecoration = DividerItemDecoration(rv_news_list.context,DividerItemDecoration.VERTICAL)
        newsAdapter = NewsAdapter()
        rv_news_list.layoutManager = LinearLayoutManager(applicationContext)
        rv_news_list.adapter = newsAdapter
        rv_news_list.addItemDecoration(dividerItemDecoration)


        getNewsData()


    }

    private fun getNewsData(): Disposable = NewsApiClient.getNewsApiService().getNews("in", "219137898ca04dc29a138ef79827cd99")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            newsAdapter.news = it.articles
            newsAdapter.notifyDataSetChanged()
        },
            {
                Toast.makeText(this, "OOps error ${it.message}", Toast.LENGTH_SHORT).show()
            })
}


