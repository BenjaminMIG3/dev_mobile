package com.ynov.example.dev_mobile.data

import com.ynov.example.dev_mobile.domain.TvShow
import com.ynov.example.dev_mobile.domain.TvShowDetail
import com.ynov.example.dev_mobile.domain.TvShowRepository
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TvShowRepository {
    override suspend fun getPopularShows(page: Int): List<TvShow> {
        return apiService.getPopularShows(page).tvShows.map { it.toDomain() }
    }

    override suspend fun getShowDetails(showId: String): TvShowDetail {
        return apiService.getShowDetails(showId).tvShow.toDomain()
    }
}