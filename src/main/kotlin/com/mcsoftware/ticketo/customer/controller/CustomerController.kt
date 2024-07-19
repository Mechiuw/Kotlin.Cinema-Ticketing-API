package com.mcsoftware.ticketo.customer.controller

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import jakarta.persistence.PreUpdate
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_CUSTOMER)
class CustomerController(
    private val service: CustomerService,
    private val json: ResponseJSON<Any>,
) {
    @PostMapping
    fun create(@RequestBody request: CustomerRequest) :ResponseEntity<Any>{
        val createService = service.createCustomer(request)
        val response = json.apply {
            statusCode = HttpStatus.CREATED.value()
        }.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }

    @PutMapping(AppEndpoint.PUT_ID)
    fun update(@PathVariable id:UUID,@RequestBody request:CustomerRequest) :ResponseEntity<Any>{
        val updateService = service.updateCustomer(id,request)
        val response = json.apply {
            statusCode = HttpStatus.OK.value()
        }.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @DeleteMapping(AppEndpoint.DEL_ID)
    fun delete(@PathVariable id:UUID):ResponseEntity<Any>{
        val deleteService = service.deleteCustomer(id)
        val response = json.apply {
            statusCode = HttpStatus.OK.value()
        }.useResponse(deleteService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @GetMapping(AppEndpoint.GET_ID)
    fun getCustomer(@PathVariable id:UUID):ResponseEntity<Any>{
        val fetchService = service.getCustomer(id)
        val response = json.apply {
            statusCode = HttpStatus.OK.value()
        }.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @GetMapping(AppEndpoint.GET_ID)
    fun allCustomer():ResponseEntity<Any>{
        val fetchService = service.allCustomer()
        val response = json.apply {
            statusCode = HttpStatus.OK.value()
        }.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
}