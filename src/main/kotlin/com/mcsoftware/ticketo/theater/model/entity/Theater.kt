package com.mcsoftware.ticketo.theater.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.mcsoftware.ticketo.movie.model.entity.Movie
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.UUID

data class Theater(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "theater_id", updatable = false, nullable = false)
    val id:UUID = UUID.randomUUID(),

    @Column(name = "theater_number", nullable = false)
    var theaterNumber:String,

    @Column(name = "stock_seats", nullable = false)
    var stockSeats:Int,

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false)
    var filmId:Movie,
    
)
