package com.keepcoding.finalproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.keepcoding.finalproject.converters.Converters
import com.keepcoding.finalproject.data.local.model.MovieLocal

@Database(entities = [MovieLocal::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {
    // List of Dao
    abstract fun movieDao(): MovieDao
}
