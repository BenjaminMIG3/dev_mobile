package com.ynov.example.dev_mobile.domain

interface TvShowRepository {
    suspend fun getPopularShows(page: Int): List<TvShow>
    suspend fun getShowDetails(showId: String): TvShowDetail
}