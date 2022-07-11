package com.example.cinaeste.data.models

data class Actor (
    val name : String,
    val movies : List<Movie> = ArrayList()
)