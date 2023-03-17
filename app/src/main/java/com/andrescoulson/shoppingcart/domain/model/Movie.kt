package com.andrescoulson.shoppingcart.domain.model

data class Movie(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val title: String,
    var selected: Boolean = false
)