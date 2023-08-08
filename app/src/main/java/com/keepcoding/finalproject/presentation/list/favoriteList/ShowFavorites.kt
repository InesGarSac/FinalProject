package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.ColorUtils
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.list.moviesList.POSTER_BASE_URL
import com.keepcoding.finalproject.ui.theme.FinalProjectTheme

@Composable
fun ShowFavoriteScreen(
    movie: MovieModel,
    onClick: (() -> Unit)? = null
    ) {

    var state by remember {
        mutableStateOf(false)
    }

        AsyncImage(
            modifier = Modifier
                .size(180.dp)
                .padding(6.dp)
                .clickable {
                    onClick?.invoke()
                },
            placeholder = painterResource(id = R.drawable.movie_image),
            error = painterResource(id = R.drawable.movie_image),
            model = ImageRequest.Builder(LocalContext.current)
                .data(POSTER_BASE_URL +"/posters/" + movie.photoUrl+ "_m.jpg")
                .build(), contentDescription = "",
            contentScale = ContentScale.FillWidth
        )



}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}