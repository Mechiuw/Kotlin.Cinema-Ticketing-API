package com.mcsoftware.ticketo.movie.service

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse


interface MovieService {
    fun createMovies(request : MovieRequest) :MovieResponse;
    fun updateMovies();
    fun deleteMovies();
    fun getMovies();
    fun allMovies();
}