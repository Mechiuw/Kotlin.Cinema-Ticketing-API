package com.mcsoftware.ticketo.rating.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.service.RatingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_RATING)
class RatingController(
    private val service : RatingService
) {
    fun create(request:RatingRequest):ResponseEntity<Any>{
        val createService = service.createRating(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(createService)
        return  ResponseEntity(response,HttpStatus.CREATED)
    }

    fun update(id:UUID,request: RatingRequest):ResponseEntity<Any>{
        val updateService = service.updateRating(id,request)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delete(id:UUID):ResponseEntity<Any>{
        val delService = service.deleteRating(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(delService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun getRating(id:UUID):ResponseEntity<Any>{
        val fetchService = service.getRating(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun allRating():ResponseEntity<Any>{
        val fetchService = service.allRating()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delAll():ResponseEntity<Any>{
        val fetchService = service.delAll()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
}