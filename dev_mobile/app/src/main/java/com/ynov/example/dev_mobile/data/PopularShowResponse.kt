package com.ynov.example.dev_mobile.data

import com.google.gson.annotations.SerializedName
import com.ynov.example.dev_mobile.domain.TvShow

data class PopularShowsResponse(
    val page: Int,
    val pages: Int,
    @SerializedName("tv_shows") val tvShows: List<TvShowDto>
)

data class TvShowDto(
    val id: Int,
    val name: String,
    @SerializedName("image_thumbnail_path") val imageUrl: String
) {
    fun toDomain(): TvShow {
        return TvShow(
            id = id,
            name = name,
            imageUrl = imageUrl
        )
    }
}