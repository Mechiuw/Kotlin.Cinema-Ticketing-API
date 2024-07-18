package com.mcsoftware.ticketo.ticket.repository

import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TrxTicketRepository : JpaRepository<TrxTicket,UUID> {
}