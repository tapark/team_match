package com.teddy_park.team_match.ui.my_club.team_match

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.team_match.MainActivity
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.databinding.FragmentTeamMatchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamMatchFragment: BaseFragment<FragmentTeamMatchBinding, TeamMatchViewModel>() {
    override val viewModel: TeamMatchViewModel by viewModels()
    override val layout: Int = R.layout.fragment_team_match

    override fun onBackPressed() {
        (activity as MainActivity).removeFragment()
    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}