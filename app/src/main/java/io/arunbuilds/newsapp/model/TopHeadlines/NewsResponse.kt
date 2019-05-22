package io.arunbuilds.newsapp.model.TopHeadlines

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)