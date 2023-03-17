package com.andrescoulson.shoppingcart.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrescoulson.shoppingcart.domain.usecase.GetLastMoviesUseCase
import com.andrescoulson.shoppingcart.presentation.movielist.MovieUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    getLastMoviesUseCase: GetLastMoviesUseCase
) : ViewModel() {

    val movieUiState: StateFlow<MovieUiState> = getLastMoviesUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    init {
        viewModelScope.launch {
            getLastMoviesUseCase()
        }
    }

}