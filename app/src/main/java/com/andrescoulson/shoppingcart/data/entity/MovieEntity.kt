package com.andrescoulson.shoppingcart.data.entity


import com.andrescoulson.shoppingcart.domain.model.Movie
import com.andrescoulson.shoppingcart.utils.toImageUrlW500
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieEntity(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
)

fun MovieEntity.toMap() = Movie(
    id = this.id,
    originalTitle = this.originalTitle,
    overview = this.overview,
    posterPath = this.posterPath.toImageUrlW500(),
    title = this.title
)