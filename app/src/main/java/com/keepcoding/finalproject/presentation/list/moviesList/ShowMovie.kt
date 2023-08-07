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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.MovieTestDataBuilder
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.detail.extractYearFromDate

const val POSTER_BASE_URL = "https://wsrv.nl/?url=https://simkl.in"

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
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
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
                    .data(POSTER_BASE_URL +"/posters/" + movie.photoUrl+ "_m.jpg")
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
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }


                //Release date
                Row (
                    modifier = Modifier
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        modifier = Modifier.size(16.dp, 16.dp),
                        painter = painterResource(id = R.drawable.release_date_image),
                        contentDescription = stringResource(R.string.release_date_description)
                    )
                    extractYearFromDate(movie.releaseDate)?.let {
                        androidx.compose.material.Text(
                            text = it,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                }

                Row (
                    modifier = Modifier
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    //Movie rate
                    Image(
                        modifier = Modifier.size(16.dp, 16.dp),
                        painter = painterResource(id = R.drawable.rate_movie_image),
                        contentDescription = stringResource(R.string.release_date_description)
                    )

                    Text(
                        text = "4,7",
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }


                Row (
                    modifier = Modifier
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    //Movie rate
                    Image(
                        modifier = Modifier.size(16.dp, 16.dp),
                        painter = painterResource(id = R.drawable.language_image),
                        contentDescription = stringResource(R.string.release_date_description)
                    )
                    //Movie language
                    Text(
                        text = "spanish",
                        fontSize = 12.sp,
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
