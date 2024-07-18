package com.mcsoftware.ticketo.ticket.util

import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.dto.response.TrxTicketResponse
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import org.springframework.stereotype.Component
import java.util.*

@Component
class TicketConverter {
    fun convertToTicket(request : TrxTicketRequest):TrxTicket{
        try{
            return TrxTicket(
                UUID.randomUUID(),
                request.seatId,
                request.customerId
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    fun convertToResponse(entity:TrxTicket):TrxTicketResponse{
        try{
            return TrxTicketResponse(
                entity.id,
                entity.seatId,
                entity.customerId
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}