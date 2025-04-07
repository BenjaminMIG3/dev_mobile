package com.ynov.example.dev_mobile.domain

import javax.inject.Inject

class GetPopularShowsUseCase @Inject constructor(
    private val repository: TvShowRepository
) {
    suspend operator fun invoke(page: Int): List<TvShow> {
        return repository.getPopularShows(page)
    }
}