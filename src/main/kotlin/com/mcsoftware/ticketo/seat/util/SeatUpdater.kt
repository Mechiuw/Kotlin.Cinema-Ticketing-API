package com.mcsoftware.ticketo.seat.util

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.entity.Seat
import com.mcsoftware.ticketo.theater.repository.TheaterRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component

@Component
class SeatUpdater(
    private val theaterRepo: TheaterRepository
) {
    fun seatUpdater(entity: Seat, request:SeatRequest):Seat{
        try{
            val existingTheater = theaterRepo.findById(request.theaterId).orElseThrow() {NotFoundException()}
            entity.seatNumber = request.seatNumber
            entity.theaterId = existingTheater
            return entity
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}