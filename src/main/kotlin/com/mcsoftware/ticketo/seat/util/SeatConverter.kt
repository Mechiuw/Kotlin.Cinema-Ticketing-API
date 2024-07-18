package com.mcsoftware.ticketo.seat.util

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.dto.response.SeatResponse
import com.mcsoftware.ticketo.seat.model.entity.Seat
import org.springframework.stereotype.Component
import java.util.*

@Component
class SeatConverter {
    fun convertToSeat(request : SeatRequest) : Seat{
        try {
            return Seat(
                UUID.randomUUID(),
                request.seatNumber,
                request.theaterId
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
                entity.theaterId
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}