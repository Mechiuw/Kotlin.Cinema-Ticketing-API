package com.mcsoftware.ticketo.seat.util

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.dto.response.SeatResponse
import com.mcsoftware.ticketo.seat.model.entity.Seat
import com.mcsoftware.ticketo.theater.repository.TheaterRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class SeatConverter(
    private val theaterRepo: TheaterRepository
) {
    fun convertToSeat(request : SeatRequest) : Seat{
        try {
            val foundTheater = theaterRepo.findById(request.theaterId).orElseThrow()
            return Seat(
                UUID.randomUUID(),
                request.seatNumber,
                foundTheater
            )
        }    catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    fun convertToResponse(entity : Seat):SeatResponse{
        try{
            return SeatResponse(
                entity.id,
                entity.seatNumber,
                entity.theaterId.id.toString()
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}