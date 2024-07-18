package com.mcsoftware.ticketo.rating.model.dto.request

import com.mcsoftware.ticketo.movie.model.entity.Movie
import com.mcsoftware.ticketo.rating.constant.ECode
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
data class RatingRequest(
    @field:NotBlank(message = "rating code cannot be null")
    val code: ECode,
    @field:NotBlank(message = "rating description cannot be null")
    val description: String,
    val moviesLinked : List<Movie>,
)