package com.mcsoftware.ticketo.seat.service.impl

import com.mcsoftware.ticketo.seat.model.dto.request.SeatRequest
import com.mcsoftware.ticketo.seat.model.dto.response.SeatResponse
import com.mcsoftware.ticketo.seat.model.entity.Seat
import com.mcsoftware.ticketo.seat.repository.SeatRepository
import com.mcsoftware.ticketo.seat.service.SeatService
import com.mcsoftware.ticketo.seat.util.SeatConverter
import com.mcsoftware.ticketo.seat.util.SeatUpdater
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class SeatServiceImpl (
    @Autowired
    private val repo:SeatRepository,
    private val convert:SeatConverter,
    private val updater: SeatUpdater,
): SeatService {
    override fun create(request: SeatRequest): SeatResponse {
        try {
            val newSeat = convert.convertToSeat(request)
            val savedSeat = repo.save(newSeat)
            return convert.convertToResponse(savedSeat)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        } catch (e: DataAccessException) {
            throw IllegalAccessException("Database error: ${e.message}")
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }

    override fun update(id: UUID, request: SeatRequest): SeatResponse {
        try{
          val fetchSeat : Optional<Seat> = repo.findById(id)
            if(fetchSeat.isPresent){
                return convert.convertToResponse(updater.seatUpdater(fetchSeat.get(),request))
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

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun getSeat(id: UUID): SeatResponse {
        TODO("Not yet implemented")
    }

    override fun allSeat(): List<Seat> {
        TODO("Not yet implemented")
    }
}