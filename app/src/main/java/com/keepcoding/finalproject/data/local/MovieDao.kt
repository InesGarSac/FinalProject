package com.keepcoding.finalproject.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.keepcoding.finalproject.data.local.model.MovieLocal

// Create
// Read
// Update
// Delete

@Dao
interface MovieDao {

    @Query("SELECT * FROM MovieTable")
    suspend fun getAllMovies(): List<MovieLocal>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<MovieLocal>)

}
