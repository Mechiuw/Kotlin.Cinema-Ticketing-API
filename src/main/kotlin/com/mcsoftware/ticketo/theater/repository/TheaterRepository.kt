package com.mcsoftware.ticketo.theater.repository

import com.mcsoftware.ticketo.theater.model.entity.Theater
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TheaterRepository : JpaRepository<Theater, UUID> {
}