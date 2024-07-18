package com.mcsoftware.ticketo.seat.service

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.dto.response.SeatResponse
import com.mcsoftware.ticketo.seat.model.entity.Seat
import java.util.UUID

interface SeatService {
    fun create(request: SeatRequest):SeatResponse;
    fun update(id:UUID,request: SeatRequest):SeatResponse;
    fun delete(id:UUID);
    fun getSeat(id:UUID):SeatResponse;
    fun allSeat():List<Seat>;
}