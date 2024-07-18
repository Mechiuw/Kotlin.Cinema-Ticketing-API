package com.mcsoftware.ticketo.seat.util

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.entity.Seat
import org.springframework.stereotype.Component

@Component
class SeatUpdater {
    fun seatUpdater(entity: Seat, request:SeatRequest):Seat{
        try{
            entity.seatNumber = request.seatNumber
            entity.theaterId = request.theaterId
            return entity
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}