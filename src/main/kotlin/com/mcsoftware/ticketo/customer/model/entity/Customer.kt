package com.mcsoftware.ticketo.customer.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "m_customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id:String,

    @Column(name = "name", nullable = false)
    val name:String,

    @Column(name = "birth_date", nullable = false)
    val birthDate:String,

    @Column(name = "email", nullable = false)
    val email:String,

    @Column(name = "address", nullable = false)
    val address:String,
)
