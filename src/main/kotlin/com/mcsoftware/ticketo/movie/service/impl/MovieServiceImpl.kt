package com.mcsoftware.ticketo.movie.service.impl

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse
import com.mcsoftware.ticketo.movie.model.entity.Movie
import com.mcsoftware.ticketo.movie.repository.MovieRepository
import com.mcsoftware.ticketo.movie.service.MovieService
import com.mcsoftware.ticketo.movie.util.MovieConverter
import com.mcsoftware.ticketo.movie.util.MovieUpdater
import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieServiceImpl (
    private val repo : MovieRepository,
    private val convert : MovieConverter,
    private val updater : MovieUpdater,
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

    override fun updateMovies(id: UUID, request: MovieRequest) :MovieResponse{
        try{
            val fetchMovie = repo.findById(id).orElseThrow() { RuntimeException() }
            val updatedMovie = updater.updateMovie(fetchMovie,request)
            val savedMovie = repo.saveAndFlush(updatedMovie)
            return convert.convertToResponse(savedMovie)
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    override fun deleteMovies(id: UUID) {
        try{
            val fetchData = repo.findById(id).orElseThrow() { Exception() }
            repo.delete(fetchData)
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    override fun getMovies(id: UUID) :MovieResponse{
        try{
            val fetchData = repo.findById(id).orElseThrow() { Exception() }
            return convert.convertToResponse(fetchData)
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }

    override fun allMovies() :List<Movie>{
        try{
            val allData = repo.findAll()
            return if(allData.isNotEmpty()){
                allData
            } else {
                Collections.emptyList()
            }
        } catch (e:Exception){
            throw RuntimeException(e.message)
        }
    }
}