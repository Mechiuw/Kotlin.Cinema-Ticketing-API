package com.mcsoftware.ticketo.movie.service.impl

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse
import com.mcsoftware.ticketo.movie.repository.MovieRepository
import com.mcsoftware.ticketo.movie.service.MovieService
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl (private val repo : MovieRepository) : MovieService {

    override fun createMovies(request : MovieRequest): MovieResponse {


        return null;
    }

    override fun updateMovies() {
        TODO("Not yet implemented")
    }

    override fun deleteMovies() {
        TODO("Not yet implemented")
    }

    override fun getMovies() {
        TODO("Not yet implemented")
    }

    override fun allMovies() {
        TODO("Not yet implemented")
    }
}