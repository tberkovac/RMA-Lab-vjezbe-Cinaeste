package com.example.cinaeste.data

import com.example.cinaeste.favoriteMovies
import com.example.cinaeste.recentMovies

object MovieRepository {
    fun getFavoriteMovies() : List<Movie> {
        return favoriteMovies()
    }
    fun getRecentMovies() : List<Movie> {
        return recentMovies()
    }
}