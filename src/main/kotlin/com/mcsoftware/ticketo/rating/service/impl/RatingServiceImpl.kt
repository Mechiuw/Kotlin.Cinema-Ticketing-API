package com.mcsoftware.ticketo.rating.service.impl

import com.mcsoftware.ticketo.rating.model.dto.request.RatingRequest
import com.mcsoftware.ticketo.rating.model.dto.response.RatingResponse
import com.mcsoftware.ticketo.rating.model.entity.Rating
import com.mcsoftware.ticketo.rating.service.RatingService
import com.mcsoftware.ticketo.rating.repository.RatingRepository
import com.mcsoftware.ticketo.rating.util.RatingConverter
import com.mcsoftware.ticketo.rating.util.RatingUpdater
import jakarta.transaction.Transactional
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service
import java.util.*

@Service
@Transactional(rollbackOn = [Exception::class])
class RatingServiceImpl(
    private val repo : RatingRepository,
    private val convert : RatingConverter,
    private val updater : RatingUpdater
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

    override fun updateRating(id: UUID, updateRequest: RatingRequest): RatingResponse {
        try{
            val fetchRating = repo.findById(id).orElseThrow()
            val updatedRating =  updater.ratingUpdater(fetchRating,updateRequest)
            val savedRating = repo.saveAndFlush(updatedRating)
            return convert.convertToResponse(savedRating)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun deleteRating(id:UUID) {
        TODO("Not yet implemented")
    }

    override fun getRating(id: UUID): RatingResponse {
        TODO("Not yet implemented")
    }

    override fun allRating(): List<Rating> {
        TODO("Not yet implemented")
    }
}