package com.teddy_park.team_match.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClubInfo(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo val image: Bitmap? = null,
    @ColumnInfo val name: String = ""
)
