package com.ynov.example.dev_mobile.domain

import javax.inject.Inject

class GetShowDetailsUseCase @Inject constructor(
    private val repository: TvShowRepository
) {
    suspend operator fun invoke(showId: String): TvShowDetail {
        return repository.getShowDetails(showId)
    }
}