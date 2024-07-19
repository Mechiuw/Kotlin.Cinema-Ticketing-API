package com.mcsoftware.ticketo.ticket.util

import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.seat.repository.SeatRepository
import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.dto.response.TrxTicketResponse
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class TicketConverter(
    private val seatRepo : SeatRepository,
    private val customerRepo : CustomerRepository
) {
    fun convertToTicket(request : TrxTicketRequest):TrxTicket{
        try{
            val existingSeat = seatRepo.findById(request.seatId).orElseThrow() {NotFoundException()}
            val existingCustomer = customerRepo.findById(request.customerId).orElseThrow() {NotFoundException()}
            return TrxTicket(
                UUID.randomUUID(),
                existingSeat,
                existingCustomer
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    fun convertToResponse(entity:TrxTicket):TrxTicketResponse{
        try{
            return TrxTicketResponse(
                entity.id,
                entity.seatId.id,
                entity.customerId.id
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}