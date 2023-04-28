package com.teddy_park.team_match.select_club

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.databinding.FragmentSelectClubBinding

class SelectClubFragment: BaseFragment<FragmentSelectClubBinding, SelectClubViewModel>() {

    override val viewModel: SelectClubViewModel by viewModels()
    override val layout: Int = R.layout.fragment_select_club

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }




}