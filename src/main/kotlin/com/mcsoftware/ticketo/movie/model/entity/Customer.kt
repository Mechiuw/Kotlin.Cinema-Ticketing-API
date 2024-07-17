package com.mcsoftware.ticketo.movie.model.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "m_customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    val id : UUID,

    @Column(name = "")
    val profileId : String,
    val firstName : String,
    val lastName : String,
    val birthDate : Date
)
