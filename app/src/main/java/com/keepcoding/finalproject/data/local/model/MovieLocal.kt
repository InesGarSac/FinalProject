package com.keepcoding.finalproject.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MovieTable")
data class MovieLocal(
    @PrimaryKey @Embedded val ids: IdLocal,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "country") val language: String,
    @ColumnInfo(name = "releasedate") val releaseDate: String,
    @ColumnInfo(name = "overview") val description: String?,
    @ColumnInfo(name = "poster") val photo: String?,
    @ColumnInfo(name = "genre_ids") val genres: List<String>?,
    @ColumnInfo(name = "favorite") val favorite: Int?,
    @Embedded val rating: RatingLocal
)




