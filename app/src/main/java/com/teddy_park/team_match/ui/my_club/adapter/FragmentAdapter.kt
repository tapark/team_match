package com.teddy_park.team_match.ui.my_club.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.teddy_park.team_match.ui.my_club.team_match.TeamMatchFragment
import com.teddy_park.team_match.ui.my_club.team_member.TeamMemberFragment

class FragmentAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TeamMatchFragment()
            1 -> TeamMemberFragment()
            else -> TeamMatchFragment()
        }
    }

}