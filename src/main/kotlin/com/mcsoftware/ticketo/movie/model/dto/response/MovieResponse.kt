package com.mcsoftware.ticketo.movie.model.dto.response

import lombok.Data
import java.util.*

@Data
data class MovieResponse(
    val id : UUID,
    val title : String,
    val duration : Int,
    val showDate : Date,
    val ratingId : String
)
