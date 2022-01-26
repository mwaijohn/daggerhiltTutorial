package com.example.daggertuts.network

import com.example.daggertuts.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ArticleService {

    @GET("/v2/everything")
    fun listRepos(@Query("q") topic: String,
                  @Query ("apiKey") apiKey: String
    ): Call<Result>

}