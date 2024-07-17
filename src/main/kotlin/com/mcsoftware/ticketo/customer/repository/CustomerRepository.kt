package com.mcsoftware.ticketo.customer.repository

import com.mcsoftware.ticketo.customer.model.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer,String> {
}