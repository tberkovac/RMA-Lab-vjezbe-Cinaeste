package com.example.cinaeste.data.repositories

import com.example.cinaeste.data.staticdata.*
import android.content.res.Resources

object ActorMovieRepository {
    fun getActorMovies():Map<String,List<String>>{
        return movieActors()
    }
}