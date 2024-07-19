package com.mcsoftware.ticketo.movie.util

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse
import com.mcsoftware.ticketo.movie.model.entity.Movie
import com.mcsoftware.ticketo.rating.repository.RatingRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class MovieConverter(
    private val ratingRepo : RatingRepository
) {
    fun convertToMovie(request :MovieRequest) :Movie{
        try{
            val fetchRating = ratingRepo.findById(request.ratingId).orElseThrow()
            return Movie(
                UUID.randomUUID(),
                request.title,
                request.duration,
                request.showDate,
                request.price,
                fetchRating
            )
        } catch (e:Exception){
            throw Exception(e.message)
        }
    }

    fun convertToResponse(entity:Movie) : MovieResponse{
        try{
            return MovieResponse(
                entity.id,
                entity.title,
                entity.duration,
                entity.showDate,
                entity.price,
                entity.rating.id.toString()
            )
        } catch (e:Exception){
            throw Exception(e.message)
        }
    }
}