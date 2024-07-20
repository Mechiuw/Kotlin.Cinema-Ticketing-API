package com.mcsoftware.ticketo.ticket.service.interfaces

import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.dto.response.TrxTicketResponse
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import java.util.UUID

interface TrxTicketService {
    fun create(request: TrxTicketRequest):TrxTicketResponse;
    fun update(id:UUID,request: TrxTicketRequest):TrxTicketResponse;
    fun delete(id:UUID);
    fun getTicket(id:UUID):TrxTicketResponse;
    fun allTicket():List<TrxTicket>;
    fun delAllTicket();
}