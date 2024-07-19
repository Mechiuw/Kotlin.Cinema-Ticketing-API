package com.mcsoftware.ticketo.customer.controller

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(AppEndpoint.API_CUSTOMER)
class CustomerController(
    private val service: CustomerService,
    private val json: ResponseJSON<CustomerResponse>,
) {
    @PostMapping
    fun create(@RequestBody request: CustomerRequest) :ResponseEntity<ResponseJSON<CustomerResponse>>{
        val createService = service.createCustomer(request)
        val response = json.apply {
            statusCode = HttpStatus.CREATED.value()
        }.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }
}