package com.example.cinaeste.data.repositories

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cinaeste.data.models.Movie


data class MovieWithCast(
    @Embedded val movie : Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "fromMovieId"
    )
    val cast:List<Cast>
){

}