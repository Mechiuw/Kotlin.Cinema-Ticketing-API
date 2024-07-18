package com.mcsoftware.ticketo.seat.service.impl

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.dto.response.SeatResponse
import com.mcsoftware.ticketo.seat.model.entity.Seat
import com.mcsoftware.ticketo.seat.repository.SeatRepository
import com.mcsoftware.ticketo.seat.service.SeatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SeatServiceImpl (
    @Autowired
    private val repo:SeatRepository
): SeatService {
    override fun create(request: SeatRequest): SeatResponse {
        TODO("Not yet implemented")
    }

    override fun update(id: String, request: SeatRequest): SeatResponse {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun getSeat(id: String): SeatResponse {
        TODO("Not yet implemented")
    }

    override fun allSeat(): List<Seat> {
        TODO("Not yet implemented")
    }
}