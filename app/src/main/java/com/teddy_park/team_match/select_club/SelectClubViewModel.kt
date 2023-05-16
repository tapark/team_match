package com.teddy_park.team_match.select_club

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import androidx.room.Insert
import com.tapark.military_quest.base.BaseViewModel
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.model.ClubInfo
import com.teddy_park.team_match.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectClubViewModel @Inject constructor(
    private val matchRepository: MatchRepository
): BaseViewModel() {

    private val _getClubInfoListEvent = MutableLiveData<List<ClubInfo>>()
    val getClubInfoListEvent: LiveData<List<ClubInfo>> get() = _getClubInfoListEvent

    fun getClubInfoList() {

        viewModelScope.launch(Dispatchers.IO) {
            val list = matchRepository.getClubInfoList()
            _getClubInfoListEvent.postValue(list)
        }
    }

    fun insertClubInfo(clubInfo: ClubInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            matchRepository.insertClubInfo(clubInfo)
        }
    }

    fun deleteClubInfo(clubInfo: ClubInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            matchRepository.deleteClubInfo(clubInfo)
        }
    }


}