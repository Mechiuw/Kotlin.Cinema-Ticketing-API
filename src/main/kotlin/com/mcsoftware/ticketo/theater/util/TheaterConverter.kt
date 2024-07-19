package com.mcsoftware.ticketo.theater.util

import com.mcsoftware.ticketo.movie.repository.MovieRepository
import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.dto.response.TheaterResponse
import com.mcsoftware.ticketo.theater.model.entity.Theater
import org.springframework.stereotype.Component
import java.util.*

@Component
class TheaterConverter(
    private val movieRepo : MovieRepository
) {
    fun convertToTheater(request: TheaterRequest):Theater{
        try {
            val findFilm = movieRepo.findById(request.filmId).orElseThrow() { RuntimeException() }
            return Theater(
                UUID.randomUUID(),
                request.theaterNumber,
                request.stockSeats,
                findFilm
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
                entity.filmId.id
            )
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}