package com.example.lv1drugiput

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.lv1drugiput.R
import com.example.lv1drugiput.data.Movie
import com.example.lv1drugiput.viewmodel.MovieDetailViewModel

class MovieDetailActivity : AppCompatActivity() {
    private var movieDetailViewModel =  MovieDetailViewModel()
    private lateinit var movie: Movie
    private lateinit var title : TextView
    private lateinit var overview : TextView
    private lateinit var releaseDate : TextView
    private lateinit var genre : TextView
    private lateinit var website : TextView
    private lateinit var poster : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        title = findViewById(R.id.movie_title)
        overview = findViewById(R.id.movie_overview)
        releaseDate = findViewById(R.id.movie_release_date)
        genre = findViewById(R.id.movie_genre)
        poster = findViewById(R.id.movie_poster)
        website = findViewById(R.id.movie_website)
        val extras = intent.extras
        if (extras != null) {
            movie = movieDetailViewModel.getMovieByTitle(extras.getString("movie_title",""))
            populateDetails()
        } else {
            finish()
        }
    }
    private fun populateDetails() {
        title.text=movie.title
        releaseDate.text=movie.releaseDate
        genre.text=movie.genre
        website.text=movie.homePage
        overview.text=movie.overview
        val context: Context = poster.context
        var id: Int = context.resources
            .getIdentifier(movie.genre, "drawable", context.packageName)
        if (id===0) id=context.resources
            .getIdentifier("picture1", "drawable", context.packageName)
        poster.setImageResource(id)
    }
}