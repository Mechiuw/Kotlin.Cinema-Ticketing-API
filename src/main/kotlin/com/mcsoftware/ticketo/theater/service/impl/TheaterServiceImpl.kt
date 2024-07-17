package com.mcsoftware.ticketo.theater.service.impl

import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.dto.response.TheaterResponse
import com.mcsoftware.ticketo.theater.model.entity.Theater
import com.mcsoftware.ticketo.theater.repository.TheaterRepository
import com.mcsoftware.ticketo.theater.service.TheaterService
import com.mcsoftware.ticketo.theater.util.TheaterConverter
import org.springframework.dao.DataAccessException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
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
        try{
            val fetchTheater:Optional<Theater> = repo.findById(id)
            if(fetchTheater.isPresent){
                fetchTheater.get().theaterNumber = request.theaterNumber
                fetchTheater.get().stockSeats = request.stockSeats
                fetchTheater.get().filmId = request.filmId
                val updatedTheater = repo.saveAndFlush(fetchTheater.get())
                return convert.convertToResponse(updatedTheater)
            } else {
                throw NotFoundException()
            }
        }  catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun delete(id: UUID) {
        try{
            if(repo.findById(id).isPresent){
                repo.delete(repo.findById(id).orElseThrow())
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun getTheater(id: UUID): TheaterResponse {
        try{
            val fetchTheater = repo.findById(id)
                .orElseThrow()
            if(fetchTheater != null){
                return convert.convertToResponse(fetchTheater)
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun allTheater(): List<Theater> {
        try{
            val theaters: List<Theater> = repo.findAll();
            if(theaters.isNotEmpty()){
                return theaters
            } else {
                throw NotFoundException()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}