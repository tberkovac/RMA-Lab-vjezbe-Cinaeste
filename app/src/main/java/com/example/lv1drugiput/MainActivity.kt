package com.example.lv1drugiput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lv1drugiput.data.Movie
import com.example.lv1drugiput.view.MovieListAdapter
import com.example.lv1drugiput.viewmodel.MovieListViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var searchText: EditText
    private lateinit var favoriteMovies: RecyclerView
    private lateinit var recentMovies: RecyclerView
    private lateinit var favoriteMoviesAdapter: MovieListAdapter
    private lateinit var recentMoviesAdapter: MovieListAdapter
    private var movieListViewModel = MovieListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        favoriteMovies = findViewById(R.id.favoriteMovies)
        recentMovies = findViewById(R.id.recentMovies)
        searchText = findViewById(R.id.searchText)
        favoriteMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recentMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        favoriteMoviesAdapter = MovieListAdapter(arrayListOf()){
            movie -> showMovieDetails(movie)
        }
        recentMoviesAdapter = MovieListAdapter(arrayListOf()){
            movie -> showMovieDetails(movie)
        }
        favoriteMovies.adapter = favoriteMoviesAdapter
        recentMovies.adapter = recentMoviesAdapter
        favoriteMoviesAdapter.updateMovies(movieListViewModel.getFavoriteMovies())
        recentMoviesAdapter.updateMovies(movieListViewModel.getRecentMovies())

        if(intent?.action == Intent.ACTION_SEND && intent?.type == "text/plain")
            handleSendText(intent)
    }

    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            searchText.setText(it)
        }
    }

    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java).apply {
            putExtra("movie_title", movie.title)
            Log.v("Intent ", "klik na film za detalje")
        }
        startActivity(intent)
    }
}