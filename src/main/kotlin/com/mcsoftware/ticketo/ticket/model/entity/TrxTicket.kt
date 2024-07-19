package com.mcsoftware.ticketo.ticket.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.mcsoftware.ticketo.customer.model.entity.Customer
import com.mcsoftware.ticketo.seat.model.entity.Seat
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "trx_table")
data class TrxTicket(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    val id:UUID = UUID.randomUUID(),

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "seat_id", nullable = false, referencedColumnName = "id")
    var seatId:Seat,

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    var customerId:Customer
)
