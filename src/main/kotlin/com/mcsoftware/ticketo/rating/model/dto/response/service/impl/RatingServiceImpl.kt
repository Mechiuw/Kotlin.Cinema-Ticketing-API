package com.mcsoftware.ticketo.rating.model.dto.response.service.impl

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating
import com.mcsoftware.ticketo.rating.model.dto.response.service.RatingService

class RatingServiceImpl : RatingService {
    override fun createRating(request: RatingRequest): RatingResponse {
        TODO("Not yet implemented")
    }

    override fun updateRating(id: String, updateRequest: RatingRequest): RatingResponse {
        TODO("Not yet implemented")
    }

    override fun deleteRating() {
        TODO("Not yet implemented")
    }

    override fun getRating(id: String): RatingResponse {
        TODO("Not yet implemented")
    }

    override fun allRating(): List<Rating> {
        TODO("Not yet implemented")
    }
}