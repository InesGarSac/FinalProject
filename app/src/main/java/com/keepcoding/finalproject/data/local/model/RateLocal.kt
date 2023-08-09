package com.keepcoding.finalproject.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RateLocal")
data class RateLocal(
    @PrimaryKey @ColumnInfo(name = "rating") val rateValue: Double
)