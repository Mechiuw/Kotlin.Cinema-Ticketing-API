package com.mcsoftware.ticketo.theater.service.impl

import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.dto.response.TheaterResponse
import com.mcsoftware.ticketo.theater.model.entity.Theater
import com.mcsoftware.ticketo.theater.repository.TheaterRepository
import com.mcsoftware.ticketo.theater.service.TheaterService
import com.mcsoftware.ticketo.theater.util.TheaterConverter
import org.springframework.dao.DataAccessException
import java.util.*

class TheaterServiceImpl(
    private val repo: TheaterRepository,
    private val convert: TheaterConverter,
    ): TheaterService {
    override fun create(request: TheaterRequest): TheaterResponse {
        try{
            val newTheater = convert.convertToTheater(request)
            val savedTheater = repo.save(newTheater)
            return convert.convertToResponse(savedTheater)
        }  catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun update(id: UUID, request: TheaterRequest): TheaterResponse {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun getTheater(id: UUID): TheaterResponse {
        TODO("Not yet implemented")
    }

    override fun allTheater(): List<Theater> {
        TODO("Not yet implemented")
    }
}