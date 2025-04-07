package com.ynov.example.dev_mobile.domain

data class TvShow(
    val id: Int,
    val name: String,
    val imageUrl: String
)

data class TvShowDetail(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
)