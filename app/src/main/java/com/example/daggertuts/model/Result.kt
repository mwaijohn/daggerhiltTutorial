package com.example.daggertuts.model

import com.google.gson.annotations.SerializedName

data class Result (

    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("articles") val articles : List<Article>
)
