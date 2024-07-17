package com.mcsoftware.ticketo.customer.model.dto.response

import lombok.Data
import java.util.UUID

@Data
data class CustomerResponse(
    val id : UUID,
    val name : String,
    val birthDate : String,
    val email : String,
    val address : String,
)
