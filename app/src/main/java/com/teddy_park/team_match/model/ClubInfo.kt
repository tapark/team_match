package com.teddy_park.team_match.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "clubInfo")
data class ClubInfo(
    @PrimaryKey(autoGenerate = true)
    @SerialName("id")
    val id: Int = 0,

//    @SerialName("image")
//    val image: Bitmap? = null,

    @SerialName("name")
    val name: String = ""
)
