package com.keepcoding.finalproject.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.keepcoding.finalproject.data.remote.dto.IdDto
import com.squareup.moshi.Json
import com.squareup.moshi.Types


@Entity(tableName = "MovieTable")
data class MovieLocal(
    @Embedded val ids: IdLocal,
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
//    @ColumnInfo(name = "rate") val rate: String,
//    @ColumnInfo(name = "language") val language: String,
    @ColumnInfo(name = "releasedate") val releaseDate: String,
    @ColumnInfo(name = "overview") val description: String?,
    @ColumnInfo(name = "poster") val photo: String?,
    @ColumnInfo(name = "genre_ids") val genres: List<String>?,
    @ColumnInfo(name = "favorite") val favorite: Int?
)




