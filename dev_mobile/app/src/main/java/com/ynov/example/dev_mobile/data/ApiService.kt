package com.ynov.example.dev_mobile.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("most-popular")
    suspend fun getPopularShows(@Query("page") page: Int): PopularShowsResponse

    @GET("show-details")
    suspend fun getShowDetails(@Query("q") showId: String): ShowDetailsResponse
}