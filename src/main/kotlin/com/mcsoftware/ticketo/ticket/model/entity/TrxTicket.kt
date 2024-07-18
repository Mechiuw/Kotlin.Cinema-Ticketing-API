package com.mcsoftware.ticketo.ticket.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "trx_table")
data class TrxTicket(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    val id:UUID = UUID.randomUUID(),

    @Column(name = "seat_id", updatable = false, nullable = false)
    val seatId:UUID = UUID.randomUUID(),

    @Column(name = "customer_id", updatable = false, nullable = false)
    val customerId:UUID = UUID.randomUUID()
)
