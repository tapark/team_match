package com.teddy_park.team_match.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teddy_park.team_match.dao.MatchDao
import com.teddy_park.team_match.model.ClubInfo

@Database(entities = [ClubInfo::class], version = 1, exportSchema = false)
abstract class MatchDatabase : RoomDatabase() {
    abstract fun posDao(): MatchDao
}