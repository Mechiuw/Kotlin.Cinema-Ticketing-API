package com.mcsoftware.ticketo.movie.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.json.ResponseJSON
import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(AppEndpoint.API_MOVIE)
class MovieController(
    private val service : MovieService
) {
    fun create(request:MovieRequest) : ResponseEntity<Any>{
        val createService = service.createMovies(request)
        val json = ResponseJSON<Any>(HttpStatus.CREATED.value())
        val response = json.useResponse(createService)
        return ResponseEntity(response,HttpStatus.CREATED)
    }
    fun update(id:UUID,request:MovieRequest) :  ResponseEntity<Any>{
        val updateService = service.updateMovies(id,request)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(updateService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delete(id:UUID) :  ResponseEntity<Any>{
        val deleteService = service.deleteMovies(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(deleteService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun getMovie(id:UUID) :  ResponseEntity<Any>{
        val fetchService = service.getMovies(id)
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun allMovie(request:MovieRequest) :  ResponseEntity<Any>{
        val fetchService = service.allMovies()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(fetchService)
        return ResponseEntity(response,HttpStatus.OK)
    }
    fun delAllMovie(request:MovieRequest) :  ResponseEntity<Any>{
        val deleteService = service.delAllMovies()
        val json = ResponseJSON<Any>(HttpStatus.OK.value())
        val response = json.useResponse(deleteService)
        return ResponseEntity(response,HttpStatus.OK)
    }
}