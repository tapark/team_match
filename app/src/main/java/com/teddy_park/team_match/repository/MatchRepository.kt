package com.teddy_park.team_match.repository

import com.teddy_park.team_match.dao.MatchDao
import com.teddy_park.team_match.model.ClubInfo
import javax.inject.Inject

class MatchRepository @Inject constructor(
    private val matchDao: MatchDao
) {

    fun getClubInfoList(): List<ClubInfo> {
        return matchDao.getClubInfoList()
    }

    fun insertClubInfo(clubInfo: ClubInfo) {
        matchDao.insertClubInfo(clubInfo)
    }

    fun deleteClubInfo(clubInfo: ClubInfo) {
        matchDao.deleteClubInfo(clubInfo)
    }

}