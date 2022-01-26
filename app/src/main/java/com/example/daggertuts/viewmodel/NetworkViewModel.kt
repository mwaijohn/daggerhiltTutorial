package com.example.daggertuts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggertuts.Constants
import com.example.daggertuts.model.Article
import javax.inject.Inject
import com.example.daggertuts.model.Result
import com.example.daggertuts.network.ArticleService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

@HiltViewModel
class NetworkViewModel @Inject constructor(retrofit: Retrofit): ViewModel() {

    val data: MutableLiveData<List<Article>> by lazy {
        MutableLiveData<List<Article>>()
    }

    init {
        val articleService = retrofit.create(ArticleService::class.java)
        val call: Call<Result> = articleService.listRepos("bitcoin",Constants.API_KEY)
        call.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val result = response.body()
                val articles = result?.articles
                data.value = articles
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                data.value = emptyList()
            }
        })
    }

    fun getData(): LiveData<List<Article>> {
        return data
    }
}