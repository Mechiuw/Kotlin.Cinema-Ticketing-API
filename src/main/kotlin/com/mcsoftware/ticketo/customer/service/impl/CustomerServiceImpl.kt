package com.mcsoftware.ticketo.customer.service.impl

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService

class CustomerServiceImpl : CustomerService {
    override fun createCustomer(request: CustomerRequest): CustomerResponse {


        return
    }

    override fun updateCustomer(id: String, request: CustomerRequest): CustomerResponse {
        TODO("Not yet implemented")
    }

    override fun deleteCustomer(id: String) {
        TODO("Not yet implemented")
    }

    override fun getCustomer(id: String): CustomerResponse {
        TODO("Not yet implemented")
    }

    override fun allCustomer(): List<Customer> {
        TODO("Not yet implemented")
    }
}