package com.mcsoftware.ticketo.customer.service.interfaces

import com.mcsoftware.ticketo.customer.model.dto.request.CustomerRequest
import com.mcsoftware.ticketo.customer.model.dto.response.CustomerResponse
import com.mcsoftware.ticketo.customer.model.entity.Customer

interface CustomerService {
    fun createCustomer(request:CustomerRequest):CustomerResponse;
    fun updateCustomer(id:String,request:CustomerRequest):CustomerResponse;
    fun deleteCustomer(id:String);
    fun getCustomer(id:String):CustomerResponse;
    fun allCustomer():List<Customer>;
}