package com.mcsoftware.ticketo.ticket.model.dto.request

import jakarta.validation.constraints.NotBlank
import java.util.UUID

data class TrxTicketRequest(
    @field:NotBlank(message = "seat id field can't be null")
    var seatId :UUID,
    @field:NotBlank(message = "customer id field can't be null")
    var customerId :UUID,
)

