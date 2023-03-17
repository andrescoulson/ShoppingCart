package com.andrescoulson.shoppingcart.data.resources.remote

import com.andrescoulson.shoppingcart.data.entity.MoviesResponse
import com.andrescoulson.shoppingcart.data.resources.remote.api.MovieApi
import javax.inject.Inject

class RemoteSource @Inject constructor(private val api: MovieApi) {

    suspend fun getLatestMovie(): MoviesResponse {
        return api.getLatestMovie()
    }
}