package com.example.cinaeste

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.cinaeste.data.models.Movie
import com.example.cinaeste.view.ActorsFragment
import com.example.cinaeste.view.SimilarFragment
import com.example.cinaeste.viewmodel.MovieDetailViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView

class MovieDetailActivity : AppCompatActivity() {

    private var movieDetailViewModel =  MovieDetailViewModel(this@MovieDetailActivity::movieRetrieved,null,null)
    private lateinit var bottomNavigation: BottomNavigationView
    private  var movie=Movie(0,"Test","Test","Test","Test", "Test","Test")
    private lateinit var title : TextView
    private lateinit var overview : TextView
    private lateinit var releaseDate : TextView
    private lateinit var genre : TextView
    private lateinit var website : TextView
    private lateinit var poster : ImageView
    private lateinit var shareButton : FloatingActionButton
    private lateinit var backdrop : ImageView
    private val posterPath = "https://image.tmdb.org/t/p/w780"
    private val backdropPath = "https://image.tmdb.org/t/p/w500"

    private val mOnItemSelectedListener = NavigationBarView.OnItemSelectedListener{ item ->
        when(item.itemId){
            R.id.navForDetails_list_of_actors -> {
                var actorsFragment = ActorsFragment(movie.title, movie.id)
                openFragment(actorsFragment)
                return@OnItemSelectedListener true
            }
            R.id.navForDetails_similar_movies -> {
                var similarFragment = SimilarFragment(movie.title, movie.id)
                openFragment(similarFragment)
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        title = findViewById(R.id.movie_title)
        overview = findViewById(R.id.movie_overview)
        releaseDate = findViewById(R.id.movie_release_date)
        genre = findViewById(R.id.movie_genre)
        poster = findViewById(R.id.movie_poster)
        website = findViewById(R.id.movie_website)
        shareButton = findViewById(R.id.shareButton)
        bottomNavigation = findViewById(R.id.detailNavigation)
        bottomNavigation.setOnItemSelectedListener(mOnItemSelectedListener)
        backdrop = findViewById(R.id.movie_backdrop)

        website.setOnClickListener{
            showWebsite()
        }
        title.setOnClickListener{
            youtubeSearch()
        }
        shareButton.setOnClickListener{
            shareOverview()
        }
        val extras = intent.extras

        if (extras != null) {
            movie = extras.getParcelable("movie")!!
            populateDetails()
        } else {
            finish()
        }

        bottomNavigation.selectedItemId = R.id.navForDetails_list_of_actors
    }

    fun movieRetrieved(movie:Movie){
        this.movie =movie
        populateDetails()
    }

    private fun populateDetails() {
        Log.v("FILM JE", movie.toString())
        title.text=movie.title
        releaseDate.text=movie.releaseDate
        website.text=movie.homepage
        overview.text=movie.overview

        val context: Context = poster.context

        Glide.with(context)
            .load(posterPath + movie.posterPath)
            .into(poster)
        var backdropContext: Context = backdrop.context
        Glide.with(backdropContext)
            .load(backdropPath + movie.backdropPath)
            .centerCrop()
            .placeholder(R.drawable.backdrop)
            .error(R.drawable.backdrop)
            .fallback(R.drawable.backdrop)
            .into(backdrop)
    }

    private fun showWebsite(){

        val webIntent: Intent = Uri.parse(movie.homepage).let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        try {
            startActivity(webIntent)
        } catch (e: ActivityNotFoundException) {
            // Definisati naredbe ako ne postoji aplikacija za navedenu akciju
        }
    }

    private fun youtubeSearch(){
        val intent = Intent(Intent.ACTION_SEARCH).apply {
            setPackage("com.google.android.youtube")
            putExtra("query", movie.title + " trailer")
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Definisati naredbe ako ne postoji aplikacija za navedenu akciju
        }
    }

    private fun shareOverview(){
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, movie.overview)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.actorSimilarContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}