package com.example.simplerecyclerview

// APIからの返り値を置くためにデータクラスを用意
data class QiitaResponse(
    val url: String? = "",
    val title: String? = "",
    val user: User?
)
