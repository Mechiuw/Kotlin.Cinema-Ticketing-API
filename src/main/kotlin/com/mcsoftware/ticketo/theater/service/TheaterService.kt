package com.mcsoftware.ticketo.theater.service

import com.mcsoftware.ticketo.theater.model.dto.request.TheaterRequest
import com.mcsoftware.ticketo.theater.model.dto.response.TheaterResponse
import com.mcsoftware.ticketo.theater.model.entity.Theater
import java.util.UUID

interface TheaterService {
    fun create(request : TheaterRequest) :TheaterResponse;
    fun update(id:UUID,request : TheaterRequest) : TheaterResponse;
    fun delete(id:UUID);
    fun getTheater(id:UUID) : TheaterResponse;
    fun allTheater() : List<Theater>;

    fun delAllTheater()
}