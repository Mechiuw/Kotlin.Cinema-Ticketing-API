package com.mcsoftware.ticketo.movie.repository

import com.mcsoftware.ticketo.movie.model.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MovieRepository : JpaRepository<Movie,UUID> {
}