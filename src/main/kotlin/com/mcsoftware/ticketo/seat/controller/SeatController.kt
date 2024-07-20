package com.mcsoftware.ticketo.seat.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.service.SeatService
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

@RestController
@RequestMapping(AppEndpoint.API_SEAT)
class SeatController(
    private val service : SeatService
) {
    @PostMapping
    fun create(@RequestBody request:SeatRequest):ResponseEntity<Any>{
        val newSeat = service.create(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(newSeat)
        return ResponseEntity(response,HttpStatus.CREATED)
    }
    @PutMapping(AppEndpoint.PUT_ID)
    fun update(@PathVariable id:String,@RequestBody request:SeatRequest):ResponseEntity<Any>{}
    @DeleteMapping(AppEndpoint.DEL_ID)
    fun delete(@PathVariable id:String):ResponseEntity<Any>{}

    @GetMapping(AppEndpoint.GET_ID)
    fun getSeat(@PathVariable id:String):ResponseEntity<Any>{}
    @GetMapping(AppEndpoint.GET_ALL)
    fun allSeat():ResponseEntity<Any>{}
    @DeleteMapping
    fun delAllSeat():ResponseEntity<Any>{}
}