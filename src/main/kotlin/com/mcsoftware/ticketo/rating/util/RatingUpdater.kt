package com.mcsoftware.ticketo.rating.util

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.entity.Rating
import org.springframework.stereotype.Component

@Component
class RatingUpdater {
    fun ratingUpdater(rating: Rating,updateRequest: RatingRequest):Rating{
        try{
            return if(rating.moviesLinked.isNotEmpty()){
                rating.code = updateRequest.code
                rating.description = updateRequest.description
                rating.moviesLinked = updateRequest.moviesLinked
                return rating
            } else {
                rating.code = updateRequest.code
                rating.description = updateRequest.description
                return rating
            }
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}