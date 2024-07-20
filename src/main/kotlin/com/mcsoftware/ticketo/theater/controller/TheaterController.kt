package com.mcsoftware.ticketo.theater.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.service.TheaterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_THEATER)
class TheaterController(
    private val service : TheaterService
) {

    @PostMapping
    fun create(request:TheaterRequest):ResponseEntity<Any>{
        val createService  = service.create(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }
    fun update(id:UUID,request:TheaterRequest):ResponseEntity<Any>{
        val updateService  = service.update(id,request)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delete(id:UUID):ResponseEntity<Any>{
        val delService  = service.delete(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(delService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun getTheater(id:UUID):ResponseEntity<Any>{
        val fetchService  = service.getTheater(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun allTheater():ResponseEntity<Any>{
        val fetchService  = service.allTheater()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delAllTheater():ResponseEntity<Any>{
        val deleteAllService  = service.delAllTheater()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(deleteAllService)
        return ResponseEntity(response,HttpStatus.OK)
    }
}