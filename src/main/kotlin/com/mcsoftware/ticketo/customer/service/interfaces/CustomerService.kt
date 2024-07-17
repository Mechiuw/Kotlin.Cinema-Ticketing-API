package com.mcsoftware.ticketo.customer.service.interfaces

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer
import java.util.UUID

interface CustomerService {
    fun createCustomer(request:CustomerRequest):CustomerResponse;
    fun updateCustomer(id:UUID,request:CustomerRequest):CustomerResponse;
    fun deleteCustomer(id:UUID);
    fun getCustomer(id:UUID):CustomerResponse;
    fun allCustomer():List<Customer>;
}