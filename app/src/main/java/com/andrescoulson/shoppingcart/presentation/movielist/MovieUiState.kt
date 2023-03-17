package com.andrescoulson.shoppingcart.presentation.movielist

import com.andrescoulson.shoppingcart.domain.model.Movie

sealed interface MovieUiState {
    object Loading : MovieUiState
    data class Error(val throwable: Throwable) : MovieUiState
    data class Success(val data: List<Movie>) : MovieUiState
}