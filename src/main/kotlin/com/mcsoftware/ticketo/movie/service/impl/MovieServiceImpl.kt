package com.mcsoftware.ticketo.movie.service.impl

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse
import com.mcsoftware.ticketo.movie.repository.MovieRepository
import com.mcsoftware.ticketo.movie.service.MovieService
import com.mcsoftware.ticketo.movie.util.MovieConverter
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl (
    private val repo : MovieRepository,
    private val convert : MovieConverter,
) : MovieService {

    override fun createMovies(request: MovieRequest): MovieResponse {
        try{
            val newMovie = convert.convertToMovie(request)
            val savedMovie = repo.save(newMovie)
            return convert.convertToResponse(savedMovie)
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    override fun updateMovies(id: String, request: MovieRequest) {
        try{

            return
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    override fun deleteMovies(id: String) {
        TODO("Not yet implemented")
    }

    override fun getMovies(id: String) {
        TODO("Not yet implemented")
    }

    override fun allMovies() {
        TODO("Not yet implemented")
    }
}