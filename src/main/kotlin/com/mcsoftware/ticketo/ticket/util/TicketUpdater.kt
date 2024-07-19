package com.mcsoftware.ticketo.ticket.util

import com.mcsoftware.ticketo.customer.repository.CustomerRepository
import com.mcsoftware.ticketo.seat.repository.SeatRepository
import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import org.springframework.data.crossstore.ChangeSetPersister

class TicketUpdater(
    private val seatRepo : SeatRepository,
    private val customerRepo : CustomerRepository,
) {
    fun ticketUpdater(ticket : TrxTicket, request : TrxTicketRequest):TrxTicket{
        try{
            val existingSeat = seatRepo.findById(request.seatId).orElseThrow() { ChangeSetPersister.NotFoundException() }
            val existingCustomer = customerRepo.findById(request.customerId).orElseThrow() { ChangeSetPersister.NotFoundException() }
            ticket.seatId = existingSeat
            ticket.customerId = existingCustomer
            return ticket
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}