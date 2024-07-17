package com.mcsoftware.ticketo.customer.service.impl

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService

class CustomerServiceImpl (private val repo: CustomerRepository):CustomerService {
    override fun createCustomer(request: CustomerRequest): CustomerResponse {
        try {
            val customer = Customer("", request.name, request.birthDate, request.email, request.address)
            val savedCustomer: Customer = repo.save(customer)
            return CustomerResponse(
                savedCustomer.id,
                savedCustomer.name,
                savedCustomer.birthDate,
                savedCustomer.email,
                savedCustomer.address
            )
        } catch (e:Exception){
            throw RuntimeException(e.message);
        }
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