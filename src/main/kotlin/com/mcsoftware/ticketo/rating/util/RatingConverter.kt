package com.mcsoftware.ticketo.rating.util

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.entity.Rating
import org.springframework.stereotype.Component
import java.util.*

@Component
class RatingConverter {
    fun convertToRating(request : RatingRequest): Rating{
        try{
            if(request.moviesLinked.isEmpty())
            return Rating(
                UUID.randomUUID(),
                request.code,
                request.description,
                Collections.emptyList()
            )
            else {
                return Rating(
                    UUID.randomUUID(),
                    request.code,
                    request.description,
                    request.moviesLinked
                )
            }
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}