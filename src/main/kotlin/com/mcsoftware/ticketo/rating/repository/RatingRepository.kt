package com.mcsoftware.ticketo.rating.repository

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RatingRepository : JpaRepository<Rating, UUID>{}