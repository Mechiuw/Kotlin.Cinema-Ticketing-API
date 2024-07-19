package com.mcsoftware.ticketo.theater.util

import com.mcsoftware.ticketo.movie.repository.MovieRepository
import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.entity.Theater
import org.springframework.stereotype.Component

@Component
class TheaterUpdater(
    private val movieRepo: MovieRepository
) {
    fun updaterTheater(entity:Theater,requestUpdate : TheaterRequest):Theater{
        try{
            val existingFilm = movieRepo.findById(requestUpdate.filmId).orElseThrow() {(RuntimeException())}
            entity.theaterNumber = requestUpdate.theaterNumber
            entity.stockSeats = requestUpdate.stockSeats
            entity.filmId = existingFilm
            return entity
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}