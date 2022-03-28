package com.example.lv1drugiput.data

import com.example.lv1drugiput.favoriteMovies
import com.example.lv1drugiput.recentMovies

object MovieRepository {
    fun getFavoriteMovies() : List<Movie> {
        return favoriteMovies()
    }
    fun getRecentMovies() : List<Movie> {
        return recentMovies()
    }
}