package com.mcsoftware.ticketo.seat.model.entity

import com.mcsoftware.ticketo.theater.model.entity.Theater
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data
import java.util.*

@Data
data class Seat(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    val id:UUID = UUID.randomUUID(),

    @Column(name = "seat_number", nullable = false)
    var seatNumber: String,

    @Column(name = "theater_id", nullable = false)
    var theaterId : Theater,
)
