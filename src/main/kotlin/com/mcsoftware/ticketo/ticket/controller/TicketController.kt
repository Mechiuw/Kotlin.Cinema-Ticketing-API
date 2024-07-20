package com.mcsoftware.ticketo.ticket.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.service.interfaces.TrxTicketService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_TICKET)
class TicketController(
    private val service : TrxTicketService
) {
    @PostMapping
    fun create(@RequestBody request:TrxTicketRequest) :ResponseEntity<Any>{
        val createService = service.create(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }
    @PutMapping(AppEndpoint.PUT_ID)
    fun update(@PathVariable id:UUID,@RequestBody request:TrxTicketRequest) :ResponseEntity<Any>{
        val updateService = service.create(request)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delete(id:UUID) :ResponseEntity<Any>{}
    fun getTicket(id:UUID) :ResponseEntity<Any>{}
    fun allTicket() :ResponseEntity<Any>{}
    fun delAllTicket() :ResponseEntity<Any>{}
}