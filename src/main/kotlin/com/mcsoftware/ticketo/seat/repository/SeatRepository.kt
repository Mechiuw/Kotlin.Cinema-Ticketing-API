package com.mcsoftware.ticketo.seat.repository

import com.mcsoftware.ticketo.seat.model.entity.Seat
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SeatRepository : JpaRepository<Seat,UUID> {
}