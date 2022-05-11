package com.example.cinaeste.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinaeste.R
import com.example.cinaeste.data.models.Movie

class MovieListAdapter(
    private var movies: List<Movie>,
    private val onItemClicked: (movie: Movie, view1: View, view2: View) -> Unit
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

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        val genreMatch: String? = movies[position].genre

        val context: Context = holder.movieImage.context

        var id: Int = context.resources.getIdentifier(genreMatch, "drawable", context.packageName)

        if (id == 0) id = context.resources.getIdentifier("defaultslika", "drawable", context.packageName)

        holder.movieImage.setImageResource(id)
        holder.itemView.setOnClickListener{ onItemClicked(movies[position],holder.movieImage, holder.movieTitle) }
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(movies: List<Movie>){
        this.movies = movies
        Log.v("TAG", movies.size.toString())
        notifyDataSetChanged()
    }

}