package com.mcsoftware.ticketo.movie.service

import com.mcsoftware.ticketo.movie.model.dto.request.MovieRequest
import com.mcsoftware.ticketo.movie.model.dto.response.MovieResponse


interface MovieService {
    fun createMovies(request : MovieRequest) :MovieResponse;
    fun updateMovies(id: String,request: MovieRequest);
    fun deleteMovies(id: String);
    fun getMovies(id: String);
    fun allMovies();
}