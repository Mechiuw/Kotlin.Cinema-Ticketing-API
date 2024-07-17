package com.mcsoftware.ticketo.customer.model.dto.request

import lombok.Data

@Data
data class CustomerRequest(
    val name: String,
    val birthDate: String,
    val email: String,
    val address: String
)
