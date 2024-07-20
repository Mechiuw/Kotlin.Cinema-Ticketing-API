package com.mcsoftware.ticketo.ticket.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.ticket.model.dto.request.TrxTicketRequest
import com.mcsoftware.ticketo.ticket.service.interfaces.TrxTicketService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
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
        val updateService = service.update(id,request)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    @DeleteMapping(AppEndpoint.DEL_ID)
    fun delete(@PathVariable id:UUID) :ResponseEntity<Any>{
        val updateService = service.delete(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    @GetMapping(AppEndpoint.GET_ID)
    fun getTicket(@PathVariable id:UUID) :ResponseEntity<Any>{
        val updateService = service.getTicket(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    @GetMapping(AppEndpoint.GET_ALL)
    fun allTicket() :ResponseEntity<Any>{
        val updateService = service.allTicket()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    @DeleteMapping
    fun delAllTicket() :ResponseEntity<Any>{
        val updateService = service.delAllTicket()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
}