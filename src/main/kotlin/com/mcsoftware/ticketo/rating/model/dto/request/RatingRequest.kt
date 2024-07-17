package com.mcsoftware.ticketo.rating.model.dto.request

import com.mcsoftware.ticketo.movie.model.entity.Movie
import com.mcsoftware.ticketo.rating.constant.ECode
import lombok.Data

@Data
data class RatingRequest(
    val code: ECode,
    val description: String,
    val moviesLinked : List<Movie>,
)