package com.example.lv1drugiput

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter(
    private var movies: List<Movie>
    ) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.kartice_elementi, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        val genreMatch: String = movies[position].genre

        val context: Context = holder.movieImage.context

        var id: Int = context.resources.getIdentifier(genreMatch, "drawable", context.packageName)

        if (id == 0) id = context.resources.getIdentifier("defaultslika", "drawable", context.packageName)

        holder.movieImage.setImageResource(id)
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

}