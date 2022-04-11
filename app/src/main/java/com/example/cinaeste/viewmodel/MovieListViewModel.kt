package com.example.cinaeste.viewmodel

import com.example.cinaeste.data.models.Movie
import com.example.cinaeste.data.repositories.MovieRepository

class MovieListViewModel {
    fun getFavoriteMovies(): List<Movie>{
        return MovieRepository.getFavoriteMovies()
    }
    fun getRecentMovies(): List<Movie>{
        return MovieRepository.getRecentMovies()
    }
}