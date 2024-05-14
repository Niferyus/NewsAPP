package com.anilderinbay.Newsapp.service

import com.anilderinbay.Newsapp.model.response.NewsResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIService {


    private val BASE_URL = "https://newsapi.org/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NewsAPI::class.java)

    fun getBreakingNews(country : String): Single<NewsResponse> {
        return api.breakingNews(country)
    }

    fun searchNews(searchTerm : String): Single<NewsResponse> {
        return api.searchNews(searchTerm)
    }

    fun saveNews(url: String): Single<NewsResponse> {
        return api.saveNews(url)
    }
}