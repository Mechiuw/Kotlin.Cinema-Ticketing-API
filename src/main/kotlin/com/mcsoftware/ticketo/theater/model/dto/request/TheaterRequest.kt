package com.mcsoftware.ticketo.theater.model.dto.request

import lombok.Data
import java.util.UUID

@Data
data class TheaterRequest(
    val theaterNumber:String,
    val stockSeats:Int,
    val filmId:UUID,
)
