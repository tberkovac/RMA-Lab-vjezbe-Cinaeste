package com.example.lv1drugiput

class MovieListViewModel {
    fun getFavoriteMovies(): List<Movie>{
        return MovieRepository.getFavoriteMovies()
    }
    fun getRecentMovies(): List<Movie>{
        return MovieRepository.getRecentMovies()
    }
}