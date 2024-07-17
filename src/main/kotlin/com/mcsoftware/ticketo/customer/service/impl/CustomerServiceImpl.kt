package com.mcsoftware.ticketo.customer.service.impl

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import com.mcsoftware.ticketo.customer.util.CustomerConverter
import com.mcsoftware.ticketo.customer.util.CustomerUpdater
import jakarta.transaction.Transactional
import org.springframework.dao.DataAccessException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
@Transactional(rollbackOn = [Exception::class])
class CustomerServiceImpl (
    private val repo: CustomerRepository,
    private val convert : CustomerConverter,
    private val updater : CustomerUpdater
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
                val updatedCustomer = repo.saveAndFlush(
                    updater.customerUpdater(fetchCustomer.get(),request))
                return convert.convertToResponse(updatedCustomer)
            } else {
                throw NotFoundException()
            }
        }  catch (e: IllegalArgumentException) {
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