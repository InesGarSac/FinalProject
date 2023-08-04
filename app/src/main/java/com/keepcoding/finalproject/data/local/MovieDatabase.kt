package com.keepcoding.finalproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.finalproject.data.local.model.MovieLocal

@Database(entities = [MovieLocal::class], version = 1, exportSchema = false)
//Database(entities = [SuperHeroLocal::class, AnotherLocal::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    // List of Dao
    abstract fun movieDao(): MovieDao
}
