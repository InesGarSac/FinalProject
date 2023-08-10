package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.components.RatingComponent
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.ui.theme.descriptionSize
import com.keepcoding.finalproject.utils.constants.POSTER_BASE_URL
import com.keepcoding.finalproject.utils.convertACROtoString
import com.keepcoding.finalproject.utils.extractYearFromDate
import com.keepcoding.finalproject.utils.mapValue

@Composable
fun ShowFavoriteScreen(
    movie: MovieModel,
    onClick: (() -> Unit)? = null
    ) {

    var state by remember {
        mutableStateOf(false)
    }
        Card(
        modifier = Modifier
            .padding(2.dp),
            shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
            backgroundColor = MaterialTheme.colors.surface

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
                        onClick?.invoke()
                    }
                    .alpha(0.8f),
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
                                this.contentDescription = movie.title
                            },
                            text = movie.title,
                            fontSize = descriptionSize,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colors.onSurface
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
                            contentDescription = stringResource(R.string.release_date_description),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant)
                        )

                        extractYearFromDate(movie.releaseDate)?.let {
                            Text(
                                modifier= Modifier.semantics {
                                    this.contentDescription = it
                                }
                                    .padding(
                                        start = 5.dp
                                    ),
                                text = it,
                                fontSize = descriptionSize,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = MaterialTheme.colors.onSurface
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
                            contentDescription = stringResource(R.string.language),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant),

                        )
                        //Movie language
                        Text(
                            modifier= Modifier.semantics {
                                this.contentDescription = movie.language
                            }
                                .padding(
                                    start = 5.dp
                                ),
                            text = convertACROtoString(movie.language),
                            fontSize = descriptionSize,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colors.onSurface
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        //Movie rate
                        Column {
                            RatingComponent(rating = mapValue(movie.rating.rateVote.rate))
                        }

                    }

                }
            }
        }
    }



}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}