package com.example.cinaeste.viewmodel

import com.example.cinaeste.data.models.*
import com.example.cinaeste.data.repositories.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val searchDone: ((movies: List<Movie>) -> Unit)?,
    private val onError: (()->Unit)?) {

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun getFavoriteMovies(): List<Movie>{
        return MovieRepository.getFavoriteMovies()
    }
    fun getRecentMovies(): List<Movie>{
        return MovieRepository.getRecentMovies()
    }

    fun search(query: String){
        // Kreira se Coroutine na UI
        scope.launch{
            // Vrši se poziv servisa i suspendira se rutina dok se `withContext` ne završi
            val result = MovieRepository.searchRequest(query)
            // Prikaže se rezultat korisniku na glavnoj niti
            when (result) {
                is Result.Success<List<Movie>> -> searchDone?.invoke(result.data)
                else-> onError?.invoke()
            }
        }

    }



}