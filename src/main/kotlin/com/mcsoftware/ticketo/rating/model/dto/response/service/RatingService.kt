package com.mcsoftware.ticketo.rating.model.dto.response.service

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating

interface RatingService {
    fun createRating(request: RatingRequest) : RatingResponse
    fun updateRating(id:String,updateRequest: RatingRequest) : RatingResponse
    fun deleteRating()
    fun getRating(id:String) : RatingResponse
    fun allRating() : List<Rating>
}