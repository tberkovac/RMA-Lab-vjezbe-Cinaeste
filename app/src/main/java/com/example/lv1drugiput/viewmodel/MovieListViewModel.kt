package com.example.lv1drugiput.viewmodel

import com.example.lv1drugiput.data.Movie
import com.example.lv1drugiput.data.MovieRepository

class MovieListViewModel {
    fun getFavoriteMovies(): List<Movie>{
        return MovieRepository.getFavoriteMovies()
    }
    fun getRecentMovies(): List<Movie>{
        return MovieRepository.getRecentMovies()
    }
}