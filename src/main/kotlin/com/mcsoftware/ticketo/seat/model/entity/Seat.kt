package com.mcsoftware.ticketo.seat.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.mcsoftware.ticketo.theater.model.entity.Theater
import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity
@Table(name = "t_seat")
data class Seat(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    val id:UUID = UUID.randomUUID(),

    @Column(name = "seat_number", nullable = false)
    var seatNumber: String,

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "theater_id", nullable = false, referencedColumnName = "id")
    var theaterId : Theater,
)
