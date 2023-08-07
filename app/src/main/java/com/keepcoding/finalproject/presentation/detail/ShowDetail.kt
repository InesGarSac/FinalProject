package com.keepcoding.finalproject.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.finalproject.R
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.presentation.list.moviesList.POSTER_BASE_URL
import java.text.SimpleDateFormat


@Composable
fun ShowDetail(
    movie: MovieModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    .data(POSTER_BASE_URL + movie.photoUrl)
                    .build(), contentDescription = ""
            )
        }

        Text(
            modifier = Modifier.padding(10.dp),
            text = movie.title,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis)

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Lenguaje",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(
                modifier = Modifier.padding(10.dp),
                text = "|",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(
                modifier = Modifier.padding(10.dp),
                text = movie.genres.toString(),
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(
                modifier = Modifier.padding(10.dp),
                text = "|",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Estrellas",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(
                modifier = Modifier.padding(10.dp),
                text = "|",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            extractYearFromDate(movie.releaseDate)?.let {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = it,
                    fontSize = 14.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis)
            }
        }

        Text(
            modifier = Modifier.padding(10.dp),
            text = "Descripción",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
        Text(
            modifier = Modifier.padding(10.dp),
            text = movie.overview
            ,
            fontSize = 14.sp,
            maxLines = 8,
            overflow = TextOverflow.Ellipsis)

    }
}

fun extractYearFromDate(dateAsString: String): String? {
    val formatFromApi = SimpleDateFormat("dd/MM/yyyy")
    val myFormat = SimpleDateFormat("yyyy")
    return formatFromApi.parse(dateAsString)?.let { date ->
        myFormat.format(date)
    }
}
