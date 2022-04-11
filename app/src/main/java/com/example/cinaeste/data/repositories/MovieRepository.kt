package com.example.cinaeste.data.repositories

import com.example.cinaeste.data.models.Movie
import com.example.cinaeste.data.staticdata.favoriteMovies
import com.example.cinaeste.data.staticdata.recentMovies
import com.example.cinaeste.data.staticdata.similarMovies

object MovieRepository {
    fun getFavoriteMovies() : List<Movie> {
        return favoriteMovies()
    }
    fun getRecentMovies() : List<Movie> {
        return recentMovies()
    }
    fun getSimilarMovies(): Map<String, List<String>> {
        return similarMovies()
    }
}