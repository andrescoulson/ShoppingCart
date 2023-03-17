package com.andrescoulson.shoppingcart.data.resources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andrescoulson.shoppingcart.data.resources.local.db.dao.MovieDao
import com.andrescoulson.shoppingcart.data.resources.local.db.entity.MovieEntityDb
import javax.inject.Inject

@Database(entities = [MovieEntityDb::class], version = 1)
abstract class MovieDatabase @Inject constructor() : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}