package com.teddy_park.team_match.ui.my_club.team_member

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.databinding.FragmentTeamMemberBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamMemberFragment: BaseFragment<FragmentTeamMemberBinding, TeamMemberViewModel>() {
    override val viewModel: TeamMemberViewModel by viewModels()
    override val layout: Int = R.layout.fragment_team_member

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}