package com.andrescoulson.shoppingcart.data.resources.local.db.dao

import androidx.room.*
import com.andrescoulson.shoppingcart.data.resources.local.db.entity.MovieEntityDb
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {

    @Query("SELECT * from MovieEntityDb")
    fun getListMovies(): Flow<List<MovieEntityDb>>

    @Insert
    suspend fun addMovie(item: MovieEntityDb)

    @Delete
    suspend fun deleteMovie(item: MovieEntityDb)

    @Update
    suspend fun updateMovie(item: MovieEntityDb)
}