package com.keepcoding.finalproject.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "IdTable")
data class IdLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int
)