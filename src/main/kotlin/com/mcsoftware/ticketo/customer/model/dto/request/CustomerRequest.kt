package com.mcsoftware.ticketo.customer.model.dto.request

import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
data class CustomerRequest(
    @field:NotBlank(message = "customer name cannot be null")
    val name: String,
    @field:NotBlank(message = "customer birth date cannot be null")
    val birthDate: String,
    @field:NotBlank(message = "customer email cannot be null")
    val email: String,
    @field:NotBlank(message = "customer address cannot be null")
    val address: String
)
