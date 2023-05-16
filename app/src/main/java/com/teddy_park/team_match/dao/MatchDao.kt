package com.teddy_park.team_match.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.teddy_park.team_match.model.ClubInfo

@Dao
interface MatchDao {

    @Query("SELECT * FROM ClubInfo")
    fun getClubInfoList(): List<ClubInfo>

    @Insert
    fun insertClubInfo(clubInfo: ClubInfo)

    @Delete
    fun deleteClubInfo(clubInfo: ClubInfo)

}