package com.example.cinaeste.data.repositories

import com.example.cinaeste.data.models.Movie
import com.google.gson.annotations.SerializedName

data class GetSimilarResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>
)
