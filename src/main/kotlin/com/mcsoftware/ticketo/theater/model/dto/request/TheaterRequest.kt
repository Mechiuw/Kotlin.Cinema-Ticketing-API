package com.mcsoftware.ticketo.theater.model.dto.request

import jakarta.validation.constraints.NotBlank
import lombok.Data
import java.util.UUID

@Data
data class TheaterRequest(
    @field:NotBlank(message = "rating theater number cannot be null")
    val theaterNumber:String,
    @field:NotBlank(message = "rating stock seats cannot be null")
    val stockSeats:Int,
    @field:NotBlank(message = "rating film id cannot be null")
    val filmId:UUID,
)
