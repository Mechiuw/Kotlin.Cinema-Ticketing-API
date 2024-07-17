package com.mcsoftware.ticketo.customer.model.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "m_customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", updatable = false, nullable = false)
    var id: UUID = UUID.randomUUID(),

    @Column(name = "name", nullable = false)
    var name:String,

    @Column(name = "birth_date", nullable = false)
    var birthDate:String,

    @Column(name = "email", nullable = false)
    var email:String,

    @Column(name = "address", nullable = false)
    var address:String,
)
