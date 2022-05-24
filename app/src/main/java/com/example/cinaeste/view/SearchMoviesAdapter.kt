package com.example.cinaeste.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinaeste.R
import com.example.cinaeste.data.models.Movie

class SearchMoviesAdapter : RecyclerView.Adapter<SearchMoviesAdapter.MovieViewHolder>(){
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        var movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
    }

    private val posterPath = "https://image.tmdb.org/t/p/w342"
    private var movies  = mutableListOf<Movie>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchMoviesAdapter.MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.kartice_elementi, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchMoviesAdapter.MovieViewHolder, position: Int) {
        val context: Context = holder.movieImage.getContext()

        Glide.with(context)
            .load(posterPath + movies[position].posterPath)
            .centerCrop()
            .into(holder.movieImage)

        holder.movieTitle.text = movies[position].title
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateMovies(m : List<Movie>){
        movies.clear()
        movies.addAll(m.toMutableList())
        notifyDataSetChanged()
    }

}