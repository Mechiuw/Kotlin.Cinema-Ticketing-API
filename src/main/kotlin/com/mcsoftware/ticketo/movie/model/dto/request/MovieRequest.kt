package com.mcsoftware.ticketo.movie.model.dto.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import lombok.Builder
import java.util.*

data class MovieRequest(
    @field:NotBlank(message = "Title cannot be blank")
    val title: String,

    @field:Min(value = 1, message = "Duration must be at least 1 minute")
    val duration: Int,

    @field:NotNull(message = "Show date cannot be null")
    val showDate: Date,

    @field:Min(value = 0, message = "Price must be non-negative")
    val price: Int,

    @field:NotBlank(message = "Rating ID cannot be blank")
    val ratingId: String
)
