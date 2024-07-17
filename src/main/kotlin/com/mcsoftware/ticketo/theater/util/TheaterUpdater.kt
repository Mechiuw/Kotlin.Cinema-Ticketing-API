package com.mcsoftware.ticketo.theater.util

import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.entity.Theater
import org.springframework.stereotype.Component

@Component
class TheaterUpdater {
    fun updaterTheater(entity:Theater,requestUpdate : TheaterRequest):Theater{
        try{
            entity.theaterNumber = requestUpdate.theaterNumber
            entity.stockSeats = requestUpdate.stockSeats
            entity.filmId = requestUpdate.filmId
            return entity
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}