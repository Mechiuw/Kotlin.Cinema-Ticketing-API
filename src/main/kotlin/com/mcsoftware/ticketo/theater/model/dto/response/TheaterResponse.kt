package com.mcsoftware.ticketo.theater.model.dto.response

import lombok.Data
import java.util.UUID

@Data
data class TheaterResponse(
    val id :UUID,
    val theaterNumber:String,
    val stockSeats:Int,
    val filmId:UUID,
)
