package com.example.cinaeste.data.repositories

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.cinaeste.data.models.Movie
import com.example.cinaeste.data.repositories.SimilarMovies

data class MovieWithSimilarMovies(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(value = SimilarMovies::class,
            parentColumn = "movieId",
            entityColumn = "similarMovieId")
    )
    val similarMovies:List<Movie>
) {
}