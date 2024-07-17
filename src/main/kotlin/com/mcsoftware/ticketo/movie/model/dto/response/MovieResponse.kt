package com.mcsoftware.ticketo.movie.model.dto.response

import java.util.*

data class MovieResponse(
    val id : String,
    val title : String,
    val duration : Int,
    val showDate : Date,
    val ratingId : String
)
