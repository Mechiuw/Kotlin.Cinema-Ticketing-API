package com.mcsoftware.ticketo.movie.service

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse
import com.mcsoftware.ticketo.movie.model.entity.Movie
import java.util.*


interface MovieService {
    fun createMovies(request : MovieRequest) :MovieResponse;
    fun updateMovies(id: UUID,request: MovieRequest):MovieResponse;
    fun deleteMovies(id: UUID);
    fun getMovies(id: UUID):MovieResponse;
    fun allMovies():List<Movie>;
    fun delAllMovies();
}