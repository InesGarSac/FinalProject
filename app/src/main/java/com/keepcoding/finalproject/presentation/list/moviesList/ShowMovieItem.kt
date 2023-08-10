package com.keepcoding.finalproject.presentation.list.moviesList

import com.keepcoding.finalproject.components.RatingComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.components.StarComponent
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.detail.convertACROtoString
import com.keepcoding.finalproject.presentation.detail.extractYearFromDate
import com.keepcoding.finalproject.presentation.list.favoriteList.FavoriteListViewModel
import com.keepcoding.finalproject.ui.theme.PrimaryColor
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt

const val POSTER_BASE_URL = "https://wsrv.nl/?url=https://simkl.in"

@Composable
fun ShowMovieItem(
    movie: MovieModel,
    favoriteListViewModel: FavoriteListViewModel = koinViewModel(),
//    starVisibility: Boolean = false,
    stateOfStar: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    var state by remember {
        mutableStateOf(false)
    }
    var starred by rememberSaveable() {
        mutableStateOf(stateOfStar)
    }

        AsyncImage(
            modifier = Modifier
                .size(160.dp)
                .clickable {
                    state = !state
                    onClick?.invoke()

                }
                .alpha(0.7f)
                .zIndex(0f),
            placeholder = painterResource(id = R.drawable.movie_image),
            error = painterResource(id = R.drawable.movie_image),
            model = ImageRequest.Builder(LocalContext.current)
                .data(POSTER_BASE_URL +"/posters/" + movie.photoUrl+ "_m.jpg")
                .build(), contentDescription = "${movie.title} poster"
        )


    Box(modifier =
        Modifier
            .fillMaxSize()
            .padding(
                top = 130.dp,
                start = 80.dp
            )
    ) {

        AndroidView(
            modifier = Modifier
                .clickable {
                    val newState = !starred
                    starred = newState
                    if (starred) {
                        movie.favorite = 1
                        favoriteListViewModel.updateFavorite(movie)
                    } else {
                        movie.favorite = 0
                        favoriteListViewModel.updateFavorite(movie)
                    }
                }
                .semantics {
                    this.contentDescription = "${movie.title} saved as favorite"

                }
                .zIndex(1f),

            factory = { context ->
                StarComponent(context).apply {
                    checked = starred
                }
            },
            update = {
                it.checked = starred
            },
        )
    }

}

fun mapValue(value: Double): Double {
    var fromRange = 1..10
    var toRange = 1..5
    val fromSize = fromRange.last - fromRange.first
    val toSize = toRange.last - toRange.first
    val scaledValue = (value - fromRange.first) * toSize / fromSize
    return scaledValue + toRange.first
}

@Preview
@Composable
fun PruebaPreview(){

}