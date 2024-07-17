package com.mcsoftware.ticketo.rating.service

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating
import java.util.UUID

interface RatingService {
    fun createRating(request: RatingRequest) : RatingResponse
    fun updateRating(id:UUID,updateRequest: RatingRequest) : RatingResponse
    fun deleteRating(id : UUID)
    fun getRating(id:UUID) : RatingResponse
    fun allRating() : List<Rating>
}