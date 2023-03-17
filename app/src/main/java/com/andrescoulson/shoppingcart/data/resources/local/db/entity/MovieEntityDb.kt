package com.andrescoulson.shoppingcart.data.resources.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntityDb(
    @PrimaryKey val id: Int,
    @ColumnInfo("original_title") val originalTitle: String,
    @ColumnInfo("overview") val overview: String,
    @ColumnInfo("poster_path") val posterPath: String,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("selected") var selected: Boolean = false
)