package com.mcsoftware.ticketo.customer.util

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import java.util.*

class CustomerConverter {
    fun convertToCustomer(request : CustomerRequest) :Customer{
        try{
            return Customer(
                UUID.randomUUID(),
                request.name,
                request.birthDate,
                request.email,
                request.address
            )
        } catch (e:RuntimeException){
            throw RuntimeException(e.message)
        }
    }

    fun convertToResponse(entity : Customer) : CustomerResponse {
        try{
            return CustomerResponse(
                entity.id,
                entity.name,
                entity.birthDate,
                entity.email,
                entity.address
            )
        } catch (e : RuntimeException){
            throw RuntimeException(e.message)
        }
    }
}