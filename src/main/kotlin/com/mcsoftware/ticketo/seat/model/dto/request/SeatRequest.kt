package com.mcsoftware.ticketo.seat.model.dto.request

import jakarta.validation.constraints.NotBlank
import lombok.Data
import java.util.UUID

@Data
data class SeatRequest(
    @field:NotBlank(message = "seat can't be updated as blank or null value")
    var seatNumber:String,
    @field:NotBlank(message = "theater_id can't be updated as blank or null value")
    var theaterId:UUID,
)
