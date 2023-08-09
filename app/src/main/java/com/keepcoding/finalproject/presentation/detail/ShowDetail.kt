package com.keepcoding.finalproject.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            modifier = Modifier.padding(12.dp),
            text = movie.title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis)

        Row(modifier = Modifier
            .fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = convertACROtoString(movie.country),
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text = "|",
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

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
            text = "Genres",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)


        Text(
            modifier = Modifier.padding(10.dp),
            text = joinToString(movie.genres!!),
            fontSize = 14.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

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

fun convertACROtoString(acro: String): String{
    return when(acro){
        "us" -> "English"
        "es" -> "Spanish"
        else -> {"N/A"}
    }

}

fun joinToString(list: List<String>): String{
    return list.joinToString(", ")
}


