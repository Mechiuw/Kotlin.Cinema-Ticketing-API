package com.mcsoftware.ticketo.ticket.util

import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket

class TicketUpdater {
    fun ticketUpdater(ticket : TrxTicket, request : TrxTicketRequest):TrxTicket{
        try{
            ticket.seatId = request.seatId
            ticket.customerId = request.customerId
            return ticket
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}