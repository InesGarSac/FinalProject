package com.keepcoding.finalproject.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.components.RatingComponent
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.ui.theme.descriptionSize
import com.keepcoding.finalproject.ui.theme.subtitleSize
import com.keepcoding.finalproject.ui.theme.titleSize
import com.keepcoding.finalproject.utils.constants.POSTER_BASE_URL
import com.keepcoding.finalproject.utils.convertACROtoString
import com.keepcoding.finalproject.utils.extractYearFromDate
import com.keepcoding.finalproject.utils.joinToString
import com.keepcoding.finalproject.utils.mapValue


@Composable
fun ShowDetail(
    movie: MovieModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
        ) {

            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                placeholder = painterResource(id = R.drawable.movie_image),
                error = painterResource(id = R.drawable.movie_image),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(POSTER_BASE_URL +"/posters/" + movie.photoUrl+ "_m.jpg")
                    .build(), contentDescription = ""
            )
        }

        Text(
            modifier = Modifier.padding(12.dp)
                .semantics {
                           contentDescription = movie.title
                },
            text = movie.title,
            fontSize = titleSize,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis)

        Row(modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = convertACROtoString(movie.language),
                fontSize = descriptionSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text = "|",
                fontSize = descriptionSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            extractYearFromDate(movie.releaseDate)?.let {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = it,
                    fontSize = descriptionSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis)
            }
            Text(
                modifier = Modifier.padding(10.dp),
                text = "|",
                fontSize = descriptionSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            RatingComponent(modifier = Modifier.padding(top= 7.dp), rating = mapValue(movie.rating.rateVote.rate))
        }
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Genres",
            fontSize = subtitleSize,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)


        Text(
            modifier = Modifier.padding(10.dp),
            text = joinToString(movie.genres!!),
            fontSize = descriptionSize,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Description",
            fontSize = subtitleSize,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
        Text(
            modifier = Modifier.padding(10.dp),
            text = movie.overview
            ,
            fontSize = descriptionSize,
            overflow = TextOverflow.Ellipsis)

    }
}


