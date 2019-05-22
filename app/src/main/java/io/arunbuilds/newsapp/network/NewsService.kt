package io.arunbuilds.newsapp.network

import io.arunbuilds.newsapp.model.TopHeadlines.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
        ): Observable<NewsResponse>

}


/*
* https://newsapi.org/v2/top-headlines?
* country=us
* &
* category=business
* &
* apiKey=219137898ca04dc29a138ef79827cd99
* */