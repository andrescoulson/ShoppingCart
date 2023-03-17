package com.andrescoulson.shoppingcart.domain.usecase

import com.andrescoulson.shoppingcart.domain.model.Movie
import com.andrescoulson.shoppingcart.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getLatestMovie()
    }
}