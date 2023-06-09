package com.teddy_park.team_match.match_team

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.databinding.FragmentMatchTeamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchTeamFragment: BaseFragment<FragmentMatchTeamBinding, MatchTeamViewModel>() {
    override val viewModel: MatchTeamViewModel by viewModels()
    override val layout: Int = R.layout.fragment_match_team

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}