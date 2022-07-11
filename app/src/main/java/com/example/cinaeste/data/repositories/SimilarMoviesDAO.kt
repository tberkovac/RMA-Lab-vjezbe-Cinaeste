package com.example.cinaeste.data.repositories

import androidx.room.*
import com.example.cinaeste.data.models.Movie

@Dao
interface SimilarMoviesDAO {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun insert(join: SimilarMovies)

    @Transaction
    @Delete
    suspend fun deleteSimilar(join: SimilarMovies)

    @Transaction
    @Delete
    suspend fun deleteSimilarMovies(smovies:List<Movie>)

}