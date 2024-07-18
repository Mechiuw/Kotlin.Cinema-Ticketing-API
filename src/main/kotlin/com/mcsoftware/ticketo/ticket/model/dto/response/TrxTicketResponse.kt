package com.mcsoftware.ticketo.ticket.model.dto.response

import jakarta.validation.constraints.NotBlank
import java.util.*

data class TrxTicketResponse(
    @field:NotBlank(message = "id can't be null")
    val id:UUID,
    @field:NotBlank(message = "seat id field can't be null")
    var seatId : UUID,
    @field:NotBlank(message = "customer id field can't be null")
    var customerId : UUID,
)
