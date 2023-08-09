package com.keepcoding.finalproject.presentation.list.moviesList

import com.keepcoding.finalproject.components.RatingComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.components.StarComponent
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.detail.convertACROtoString
import com.keepcoding.finalproject.presentation.detail.extractYearFromDate
import com.keepcoding.finalproject.presentation.list.favoriteList.FavoriteListViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt

const val POSTER_BASE_URL = "https://wsrv.nl/?url=https://simkl.in"

@Composable
fun ShowMovieItem(
    movie: MovieModel,
    favoriteListViewModel: FavoriteListViewModel = koinViewModel(),
    starVisibility: Boolean = false,
    stateOfStar: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    var state by remember {
        mutableStateOf(false)
    }
    var starred by rememberSaveable() {
        mutableStateOf(stateOfStar)
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
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        state = !state
                    },
                placeholder = painterResource(id = R.drawable.movie_image),
                error = painterResource(id = R.drawable.movie_image),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(POSTER_BASE_URL +"/posters/" + movie.photoUrl+ "_m.jpg")
                    .build(), contentDescription = "${movie.title} poster"
            )
            Row(modifier = Modifier.weight(8f)) {
                Column {
                    //Movie title
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .semantics {
                                this.contentDescription = "This is the ${movie.title} film"
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier= Modifier.semantics {
                                this.contentDescription = "${movie.title}"
                            },
                            text = movie.title,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,

                        )
                    }


                    //Release date
                    Row(
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(16.dp, 16.dp),
                            painter = painterResource(id = R.drawable.release_date_image),
                            contentDescription = stringResource(R.string.release_date_description)
                        )

                        extractYearFromDate(movie.releaseDate)?.let {
                            androidx.compose.material.Text(
                                modifier= Modifier.semantics {
                                    this.contentDescription = "${it}"
                                },
                                text = it,
                                fontSize = 12.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }


                    }

                    Row(
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //Movie rate
                        Image(
                            modifier = Modifier.size(16.dp, 16.dp),
                            painter = painterResource(id = R.drawable.language_image),
                            contentDescription = stringResource(R.string.language)
                        )
                        //Movie language
                        Text(
                            modifier= Modifier.semantics {
                                this.contentDescription = "${movie.language}"
                            },
                            text = convertACROtoString(movie.language),
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //Movie rate
                        Column {
                            RatingComponent(rating = mapValue(movie.rating.rateVote.rate))
                        }

                    }

                }
            }
            if(starVisibility) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Star
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

                        },
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
        }
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