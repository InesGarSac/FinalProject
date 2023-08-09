package com.keepcoding.finalproject.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RatingLocal")
data class RatingLocal(
    @PrimaryKey @Embedded val rateVote: RateLocal
)