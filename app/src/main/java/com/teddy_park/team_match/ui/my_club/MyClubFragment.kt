package com.teddy_park.team_match.ui.my_club

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.teddy_park.team_match.MainActivity
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.databinding.FragmentMyClubBinding
import com.teddy_park.team_match.model.ClubInfo
import com.teddy_park.team_match.ui.my_club.adapter.FragmentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyClubFragment(val clubInfo: ClubInfo): BaseFragment<FragmentMyClubBinding, MyClubViewModel>() {
    override val viewModel: MyClubViewModel by viewModels()
    override val layout: Int = R.layout.fragment_my_club

    override fun onBackPressed() {
        (activity as MainActivity).removeFragment()
    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        Log.d("박태규", "clubInfo : $clubInfo")
        initViewPager()
    }

    private fun initViewPager() {
        binding.viewPager.adapter = FragmentAdapter(this)
        val tabTextList = listOf("팀 편성", "선수 관리")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTextList[position]
        }.attach()
    }
}