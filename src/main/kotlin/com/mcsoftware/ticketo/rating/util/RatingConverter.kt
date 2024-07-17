package com.mcsoftware.ticketo.rating.util

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating
import org.springframework.stereotype.Component
import java.util.*

@Component
class RatingConverter {
    fun convertToRating(request : RatingRequest): Rating{
        try{
            return if(request.moviesLinked.isEmpty())
                Rating(
                    request.code,
                    request.description,
                )
            else {
                Rating(
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

    fun convertToResponse(entity : Rating): RatingResponse{
        try{
            return RatingResponse(
                entity.id,
                entity.code,
                entity.description,
                entity.moviesLinked
            )
        }catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}