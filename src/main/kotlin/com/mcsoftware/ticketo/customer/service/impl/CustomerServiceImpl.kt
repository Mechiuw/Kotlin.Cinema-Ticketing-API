package com.mcsoftware.ticketo.customer.service.impl

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import org.springframework.dao.DataAccessException
import java.util.*

class CustomerServiceImpl (private val repo: CustomerRepository):CustomerService {
    override fun createCustomer(request: CustomerRequest): CustomerResponse {
        try {
            val customer = Customer(UUID.randomUUID(), request.name, request.birthDate, request.email, request.address)
            val savedCustomer: Customer = repo.save(customer)
            return CustomerResponse(
                savedCustomer.id,
                savedCustomer.name,
                savedCustomer.birthDate,
                savedCustomer.email,
                savedCustomer.address
            )
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun updateCustomer(id: String, request: CustomerRequest): CustomerResponse {
        try{
            val fetchCustomer = repo.findById(id)
            if(fetchCustomer.isPresent){
               var updatedCustomer = fetchCustomer.get()
                updatedCustomer.name = request.name
            }
        } catch (e:Exception){

        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
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