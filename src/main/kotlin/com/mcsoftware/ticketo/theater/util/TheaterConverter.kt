package com.mcsoftware.ticketo.theater.util

import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.dto.response.TheaterResponse
import com.mcsoftware.ticketo.theater.model.entity.Theater
import org.springframework.stereotype.Component
import java.util.*

@Component
class TheaterConverter {
    fun convertToTheater(request: TheaterRequest):Theater{
        try {
            return Theater(
                UUID.randomUUID(),
                request.theaterNumber,
                request.stockSeats,
                request.filmId
            )
        } catch(e:Exception){
            throw RuntimeException(e.message)
        }
    }

    fun convertToResponse(entity :Theater):TheaterResponse{
        try{
            return TheaterResponse(
                entity.id,
                entity.theaterNumber,
                entity.stockSeats,
                entity.filmId
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}