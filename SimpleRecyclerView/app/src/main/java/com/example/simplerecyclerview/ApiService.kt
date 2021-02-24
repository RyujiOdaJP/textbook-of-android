package com.example.simplerecyclerview

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/v2/items")

    fun apiDemo (
        //呼び出す際に必要なリクエストURLのパラメータの設定
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<QiitaResponse>>
}