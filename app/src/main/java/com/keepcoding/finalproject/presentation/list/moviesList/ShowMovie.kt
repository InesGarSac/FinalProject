package com.keepcoding.finalproject.presentation.list.moviesList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.domain.model.MovieModel

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

@Composable
fun ShowMovieItem(
    movie: MovieModel,
    onClick: (() -> Unit)? = null

) {
    var state by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.padding(2.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(Color.White)
                .clickable {
                    onClick?.invoke()
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp).clickable {
                state = !state
            },
                placeholder = painterResource(id = R.drawable.movie_image),
                error = painterResource(id = R.drawable.movie_image),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(POSTER_BASE_URL + movie.photoUrl)
                    .build(), contentDescription = ""
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                //Movie title
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = movie.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }


                //Release date
                Row (
                    modifier = Modifier
                        .background(Color.Gray)
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        modifier = Modifier.size(15.dp, 15.dp),
                        painter = painterResource(id = R.drawable.release_date_image),
                        contentDescription = stringResource(R.string.release_date_description)
                    )
                    Text(
                        text = movie.releaseDate,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row (
                    modifier = Modifier
                        .background(Color.Cyan)
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    //Movie rate
                    Image(
                        modifier = Modifier.size(15.dp, 15.dp),
                        painter = painterResource(id = R.drawable.rate_movie_image),
                        contentDescription = stringResource(R.string.release_date_description)
                    )

                    Text(
                        text = movie.rate,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }


                Row (
                    modifier = Modifier
                        .background(Color.Magenta)
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    //Movie rate
                    Image(
                        modifier = Modifier.size(15.dp, 15.dp),
                        painter = painterResource(id = R.drawable.language_image),
                        contentDescription = stringResource(R.string.release_date_description)
                    )
                    //Movie language
                    Text(
                        text = movie.language,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }
        }
    }

}


@Composable
@Preview
fun ShowHeroPreview() {
    ShowMovieItem(
        MovieTestDataBuilder()
            .withName("Sample name long text long text long text long textlong text long text long text")
            .withDescription(
                "Sample name long text long text long text long textlong text long text long text" +
                        "Sample name long text long text long text long textlong text long text long text" +
                        "Sample name long text long text long text long textlong text long text long text" +
                        "Sample name long text long text long text long textlong text long text long text" +
                        "Sample name long text long text long text long textlong text long text long text" +
                        "Sample name long text long text long text long textlong text long text long text" +
                        "Sample name long text long text long text long textlong text long text long text"
            )

            .buildSingle()
    )
}
