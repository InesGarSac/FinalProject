package com.keepcoding.finalproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.keepcoding.finalproject.utils.converters.Converters
import com.keepcoding.finalproject.data.local.model.IdLocal
import com.keepcoding.finalproject.data.local.model.MovieLocal
import com.keepcoding.finalproject.data.local.model.RateLocal
import com.keepcoding.finalproject.data.local.model.RatingLocal

@Database(entities = [MovieLocal::class, IdLocal::class, RatingLocal::class, RateLocal::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
