package com.mcsoftware.ticketo.ticket.service.impl

import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.dto.response.TrxTicketResponse
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import com.mcsoftware.ticketo.ticket.repository.TrxTicketRepository
import com.mcsoftware.ticketo.ticket.service.interfaces.TrxTicketService
import java.util.*

class TrxTicketServiceImpl(
    private val repo : TrxTicketRepository
) : TrxTicketService {
    override fun create(request: TrxTicketRequest): TrxTicketResponse {
        TODO("Not yet implemented")
    }

    override fun update(id: UUID, request: TrxTicketRequest): TrxTicketResponse {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun getTicket(id: UUID): TrxTicketResponse {
        TODO("Not yet implemented")
    }

    override fun allTicket(): List<TrxTicket> {
        TODO("Not yet implemented")
    }
}