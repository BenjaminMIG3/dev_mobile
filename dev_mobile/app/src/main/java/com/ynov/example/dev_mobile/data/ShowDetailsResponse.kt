package com.ynov.example.dev_mobile.data

import com.google.gson.annotations.SerializedName
import com.ynov.example.dev_mobile.domain.TvShowDetail

data class ShowDetailsResponse(
    @SerializedName("tvShow") val tvShow: TvShowDetailDto
)

data class TvShowDetailDto(
    val id: Int,
    val name: String,
    val description: String,
    @SerializedName("image_path") val imageUrl: String
) {
    fun toDomain(): TvShowDetail {
        return TvShowDetail(
            id = id,
            name = name,
            description = description,
            imageUrl = imageUrl
        )
    }
}