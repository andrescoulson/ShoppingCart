package com.andrescoulson.shoppingcart.data.repository

import com.andrescoulson.shoppingcart.data.entity.toMap
import com.andrescoulson.shoppingcart.data.resources.remote.RemoteSource
import com.andrescoulson.shoppingcart.domain.model.Movie
import com.andrescoulson.shoppingcart.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val remoteSource: RemoteSource) : MovieRepository {
    override fun getLatestMovie(): Flow<List<Movie>> = flow {
        val list = remoteSource.getLatestMovie().results.map { it.toMap() }
        emit(list)
    }

}