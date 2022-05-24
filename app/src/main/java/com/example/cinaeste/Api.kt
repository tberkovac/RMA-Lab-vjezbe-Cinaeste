package com.example.cinaeste

import com.example.cinaeste.data.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Response<GetMoviesResponse>

    @GET("movie/popular")
    suspend fun getFavoriteMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Response<GetMoviesResponse>

}