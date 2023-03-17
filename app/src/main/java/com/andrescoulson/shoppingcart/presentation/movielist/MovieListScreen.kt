package com.andrescoulson.shoppingcart.presentation.movielist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.andrescoulson.shoppingcart.R
import com.andrescoulson.shoppingcart.domain.model.Movie
import com.andrescoulson.shoppingcart.presentation.movielist.MovieUiState.*

@Composable
fun MovieListScreen(movieListViewModel: MovieListViewModel) {
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<MovieUiState>(
        initialValue = Loading,
        key1 = lifeCycle,
        key2 = movieListViewModel
    ) {

        lifeCycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            movieListViewModel.movieUiState.collect { value = it }
        }
    }

    when (uiState) {
        is Success -> {
            val list = (uiState as Success).data
            ListScreen(list, movieListViewModel, Modifier.fillMaxSize())
        }
        is Error -> {}
        Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier
                    .align(Alignment.Center))
            }
        }
    }
}

@Composable
fun ListScreen(list: List<Movie>, movieListViewModel: MovieListViewModel, modifier: Modifier) {
    Box(modifier = modifier) {
        MovieList(list, movieListViewModel)
        FabDialog(Modifier.align(Alignment.BottomEnd))
    }
}


@Composable
fun MovieList(list: List<Movie>, movieListViewModel: MovieListViewModel) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(list, key = { it.id }) { movie ->
            CardItemMovie(movie)
        }
    })
}

@Composable
fun CardItemMovie(movie: Movie) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp)
    ) {
        Box(modifier = Modifier.clip(RoundedCornerShape(16.dp))) {
            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = movie.originalTitle,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 5.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun FabDialog(modifier: Modifier) {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = modifier.padding(16.dp)
    ) {
        Icon(Icons.Outlined.ShoppingCart, contentDescription = "Cart")
    }
}