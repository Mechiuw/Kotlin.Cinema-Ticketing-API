package com.mcsoftware.ticketo.customer.model.dto.request

import lombok.Data

@Data
data class CustomerRequest(
    val id: String,
    val name: String,
    val birthDate: String,
    val email: String,
    val address: String
)
