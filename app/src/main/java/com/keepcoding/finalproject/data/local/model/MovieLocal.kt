package com.keepcoding.finalproject.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "MovieTable")
data class MovieLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "rate") val rate: String,
    @ColumnInfo(name = "language") val language: String,
    @ColumnInfo(name = "releasedate") val releaseDate: String,
    @ColumnInfo(name = "overview") val description: String?,
    @ColumnInfo(name = "photo") val photo: String,
)

