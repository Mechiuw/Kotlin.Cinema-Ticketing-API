package com.mcsoftware.ticketo.movie.util

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.entity.Movie
import com.mcsoftware.ticketo.movie.repository.MovieRepository
import com.mcsoftware.ticketo.rating.repository.RatingRepository
import org.hibernate.annotations.NotFound
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Component

@Component
class MovieUpdater(
    private val ratingRepo : RatingRepository
) {
    fun updateMovie(movie :Movie, request :MovieRequest) : Movie{
        try{
            val existingRating = ratingRepo.findById(request.ratingId).orElseThrow() {NotFoundException()}
            movie.title = request.title
            movie.duration = request.duration
            movie.showDate = request.showDate
            movie.price = request.price
            movie.ratingId = existingRating
            return movie
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}