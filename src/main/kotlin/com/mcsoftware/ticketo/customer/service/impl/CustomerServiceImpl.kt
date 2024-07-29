package com.mcsoftware.ticketo.customer.service.impl

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.customer.kafka.producer.KafkaProducer
import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.customer.service.interfaces.CustomerService
import com.mcsoftware.ticketo.customer.util.CustomerConverter
import com.mcsoftware.ticketo.customer.util.CustomerUpdater
import jakarta.transaction.Transactional
import org.springframework.dao.DataAccessException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
@Transactional(rollbackOn = [Exception::class])
class CustomerServiceImpl (
    private val repo: CustomerRepository,
    private val convert : CustomerConverter,
    private val updater : CustomerUpdater,
    private val producer : KafkaProducer
):CustomerService {
    override fun createCustomer(request: CustomerRequest): CustomerResponse {
        try {
            val customer = convert.convertToCustomer(request)
            val savedCustomer: Customer = repo.save(customer)
            producer.sendCustomerEvent("Created Customer ${savedCustomer.id}")
            return convert.convertToResponse(savedCustomer)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun updateCustomer(id: UUID, request: CustomerRequest): CustomerResponse {
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

    override fun deleteCustomer(id: UUID) {
        try{
            val presentCustomer = repo.findById(id).orElseThrow()
            if(presentCustomer != null){
                repo.delete(presentCustomer)
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun getCustomer(id: UUID): CustomerResponse {
        try{
            val fetchCustomer : Optional<Customer> = repo.findById(id)
            if(fetchCustomer.isPresent){
                return convert.convertToResponse(fetchCustomer.get())
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun allCustomer(): List<Customer> {
        try{
            val fetchCustomers : List<Customer> = repo.findAll()
            return fetchCustomers.ifEmpty {
                Collections.emptyList()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun delAllCustomer() {
        try{
            repo.deleteAll()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}