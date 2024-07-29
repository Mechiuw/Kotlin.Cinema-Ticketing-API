package com.mcsoftware.ticketo.ticket.repository

import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TrxTicketRepository : JpaRepository<TrxTicket,UUID> {
}