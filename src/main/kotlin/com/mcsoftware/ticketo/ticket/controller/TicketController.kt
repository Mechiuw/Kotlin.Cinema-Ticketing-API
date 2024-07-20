package com.mcsoftware.ticketo.ticket.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.service.interfaces.TrxTicketService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_TICKET)
class TicketController(
    private val service : TrxTicketService
) {
    @PostMapping
    fun create(request:TrxTicketRequest) :ResponseEntity<Any>{
        val createService = service.create(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }
    fun update(id:UUID,request:TrxTicketRequest) :ResponseEntity<Any>{}
    fun delete(id:UUID) :ResponseEntity<Any>{}
    fun getTicket(id:UUID) :ResponseEntity<Any>{}
    fun allTicket() :ResponseEntity<Any>{}
    fun delAllTicket() :ResponseEntity<Any>{}
}