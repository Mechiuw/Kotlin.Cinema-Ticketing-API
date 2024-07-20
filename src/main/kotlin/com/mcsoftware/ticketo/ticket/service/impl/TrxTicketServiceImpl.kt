package com.mcsoftware.ticketo.ticket.service.impl

import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.model.dto.response.TrxTicketResponse
import com.mcsoftware.ticketo.ticket.model.entity.TrxTicket
import com.mcsoftware.ticketo.ticket.repository.TrxTicketRepository
import com.mcsoftware.ticketo.ticket.service.interfaces.TrxTicketService
import com.mcsoftware.ticketo.ticket.util.TicketConverter
import com.mcsoftware.ticketo.ticket.util.TicketUpdater
import org.springframework.dao.DataAccessException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import java.util.*

class TrxTicketServiceImpl(
    private val repo : TrxTicketRepository,
    private val convert : TicketConverter,
    private val updater : TicketUpdater,
) : TrxTicketService {
    override fun create(request: TrxTicketRequest): TrxTicketResponse {
        try {
            val newTicket = convert.convertToTicket(request)
            val savedTicket = repo.save(newTicket)
            return convert.convertToResponse(savedTicket)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun update(id: UUID, request: TrxTicketRequest): TrxTicketResponse {
        try{
            val fetchTicket = repo.findById(id).orElseThrow {
                NotFoundException()
            }

                val updatedTicket = updater.ticketUpdater(fetchTicket, request)
                val savedTicket = repo.saveAndFlush(updatedTicket)
                return convert.convertToResponse(savedTicket)
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("Invalid input: ${e.message}")
            } catch (e: DataAccessException) {
                throw IllegalAccessException("Database error: ${e.message}")
            } catch (e: Exception) {
                throw RuntimeException("Unexpected error: ${e.message}")
        }
    }


    override fun delete(id: UUID) {
        try{
            val foundTicket = repo.findById(id).orElseThrow() { NotFoundException() }
            repo.delete(foundTicket)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun getTicket(id: UUID): TrxTicketResponse {
        try {
            val foundTicket = repo.findById(id).orElseThrow() { NotFoundException() }
            if(foundTicket != null){
                return convert.convertToResponse(foundTicket)
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun allTicket(): List<TrxTicket> {
        try {
            val foundTicket = repo.findAll()
            if(foundTicket.isNotEmpty()){
                return foundTicket
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun delAllTicket() {
        try{
            repo.deleteAll()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}