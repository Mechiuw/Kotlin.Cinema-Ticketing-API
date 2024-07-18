package com.mcsoftware.ticketo.seat.model.dto.response

import jakarta.validation.constraints.NotBlank
import lombok.Data
import java.util.*

@Data
data class SeatResponse(
    @field:NotBlank(message = "id can't be responded as blank or null value")
    val id: UUID,
    @field:NotBlank(message = "seat can't be responded as blank or null value")
    var seatNumber:String,
    @field:NotBlank(message = "theater_id can't be responded as blank or null value")
    var theaterId: String,
)
