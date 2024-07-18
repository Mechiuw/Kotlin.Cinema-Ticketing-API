package com.mcsoftware.ticketo.seat.service

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.dto.response.SeatResponse
import com.mcsoftware.ticketo.seat.model.entity.Seat

interface SeatService {
    fun create(request: SeatRequest):SeatResponse;
    fun update(id:String,request: SeatRequest):SeatResponse;
    fun delete(id:String);
    fun getSeat(id:String):SeatResponse;
    fun allSeat():List<Seat>;
}