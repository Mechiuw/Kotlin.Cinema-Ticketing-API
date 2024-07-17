package com.mcsoftware.ticketo.rating.model.dto.response.service.impl

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating
import com.mcsoftware.ticketo.rating.model.dto.response.service.RatingService
import com.mcsoftware.ticketo.rating.repository.RatingRepository
import com.mcsoftware.ticketo.rating.util.RatingConverter
import jakarta.transaction.Transactional
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service

@Service
@Transactional(rollbackOn = [Exception::class])
class RatingServiceImpl(
    private val repo : RatingRepository,
    private val convert : RatingConverter,
) : RatingService {
    override fun createRating(request: RatingRequest): RatingResponse {
        try {
            val newRating = convert.convertToRating(request)
            val savedRating = repo.save(newRating)
            return convert.convertToResponse(savedRating)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
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