package com.andrescoulson.shoppingcart.domain.repository

import com.andrescoulson.shoppingcart.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getLatestMovie(): Flow<List<Movie>>
}