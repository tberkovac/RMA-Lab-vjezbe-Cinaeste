package com.example.cinaeste

import com.example.cinaeste.data.Movie
import org.hamcrest.CoreMatchers.`is` as Is
import com.example.cinaeste.data.MovieRepository
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.junit.Assert.assertEquals
import org.junit.Test

class RepositoryUnitTest {
    @Test
    fun testGetFavoriteMovies(){
        val movies = MovieRepository.getFavoriteMovies()
        assertEquals(movies.size,6)
        assertThat(movies, hasItem<Movie>(hasProperty("title", Is("Pulp Fiction"))))
        assertThat(movies, not(hasItem<Movie>(hasProperty("title", Is("Black Widow")))))
    }

    @Test
    fun testGetRecentMovies(){
        val movies = MovieRepository.getRecentMovies()
        assertEquals(movies.size,6)
        assertThat(movies, hasItem<Movie>(hasProperty("title", Is("Top Gun: Maverick"))))
        assertThat(movies, not(hasItem<Movie>(hasProperty("title", Is("Black Widow")))))
    }
}