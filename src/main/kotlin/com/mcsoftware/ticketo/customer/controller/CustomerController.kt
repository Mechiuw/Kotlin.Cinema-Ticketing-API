package com.mcsoftware.ticketo.customer.controller

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_CUSTOMER)
class CustomerController(
    private val service: CustomerService,
) {
    @PostMapping
    fun create(@RequestBody request: CustomerRequest) :ResponseEntity<Any>{
        val createService = service.createCustomer(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }

    @PutMapping(AppEndpoint.PUT_ID)
    fun update(@PathVariable id:UUID,@RequestBody request:CustomerRequest) :ResponseEntity<Any>{
        val updateService = service.updateCustomer(id,request)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @DeleteMapping(AppEndpoint.DEL_ID)
    fun delete(@PathVariable id:UUID):ResponseEntity<Any>{
        val deleteService = service.deleteCustomer(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(deleteService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @GetMapping(AppEndpoint.GET_ID)
    fun getCustomer(@PathVariable id:UUID):ResponseEntity<Any>{
        val fetchService = service.getCustomer(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @GetMapping(AppEndpoint.GET_ALL)
    fun allCustomer():ResponseEntity<Any>{
        val fetchService = service.allCustomer()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }

    @DeleteMapping
    fun delAllCustomer():ResponseEntity<Any>{
        val delService = service.delAllCustomer()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(delService)
        return ResponseEntity(response,HttpStatus.OK)
    }
}