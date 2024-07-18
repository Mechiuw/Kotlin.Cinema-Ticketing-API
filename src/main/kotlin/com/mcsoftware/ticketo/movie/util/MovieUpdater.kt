package com.mcsoftware.ticketo.movie.util

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.entity.Movie
import org.springframework.stereotype.Component

@Component
class MovieUpdater {
    fun updateMovie(movie :Movie, request :MovieRequest) : Movie{
        try{
            movie.title = request.title
            movie.duration = request.duration
            movie.showDate = request.showDate
            movie.price = request.price
            movie.ratingId = request.ratingId
            return movie
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}