package com.mcsoftware.ticketo.customer.service.impl

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import com.mcsoftware.ticketo.customer.util.CustomerConverter
import org.springframework.dao.DataAccessException
import java.util.*

class CustomerServiceImpl (
    private val repo: CustomerRepository,
    private val convert : CustomerConverter
):CustomerService {
    override fun createCustomer(request: CustomerRequest): CustomerResponse {
        try {
            val customer = convert.convertToCustomer(request)
            val savedCustomer: Customer = repo.save(customer)
            return convert.convertToResponse(savedCustomer)
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
               fetchCustomer.get().name = request.name
                fetchCustomer.get().birthDate = request.birthDate
                fetchCustomer.get().email = request.email
                fetchCustomer.get().address = request.address
                val updatedCustomer = repo.saveAndFlush(fetchCustomer.get())
                return CustomerResponse(
                    updatedCustomer.id,
                    updatedCustomer.name,
                    updatedCustomer.birthDate,
                    updatedCustomer.email,
                    updatedCustomer.address
                )
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