package com.mcsoftware.ticketo.customer.util

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.entity.Customer
import org.springframework.stereotype.Component

@Component
class CustomerUpdater {
    fun customerUpdater(fetchedCustomer: Customer,updateRequest : CustomerRequest) : Customer {
        try{
            fetchedCustomer.name = updateRequest.name
            fetchedCustomer.birthDate = updateRequest.birthDate
            fetchedCustomer.email = updateRequest.email
            fetchedCustomer.address = updateRequest.address
            return fetchedCustomer
        } catch (e:RuntimeException){
            throw RuntimeException(e.message)
        }
    }
}