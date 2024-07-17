package com.mcsoftware.ticketo.customer.model.dto.response

import lombok.Data

@Data
data class CustomerResponse(
    val id : String,
    val name : String,
    val birthDate : String,
    val email : String,
    val address : String,
)
