package com.andrescoulson.shoppingcart.data.resources.remote.api

import com.andrescoulson.shoppingcart.data.entity.MoviesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular/")
    suspend fun getLatestMovie(): MoviesResponse
}