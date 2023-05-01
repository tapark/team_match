package com.teddy_park.team_match.select_club

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseFragment
import com.teddy_park.team_match.databinding.FragmentSelectClubBinding
import com.teddy_park.team_match.select_club.adapter.SelectClubAdapter
import com.teddy_park.team_match.select_club.dialog.HandleClubDialog
import com.teddy_park.team_match.select_club.dialog.HandleClubDialog.Companion.MODE_ADD
import com.teddy_park.team_match.util.PrefManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectClubFragment: BaseFragment<FragmentSelectClubBinding, SelectClubViewModel>() {

    override val viewModel: SelectClubViewModel by viewModels()
    override val layout: Int = R.layout.fragment_select_club

    lateinit var selectClubAdapter: SelectClubAdapter
    lateinit var handleClubDialog: HandleClubDialog

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

        initAdapter()
        initDialog()
    }

    private fun initAdapter() {
        selectClubAdapter = SelectClubAdapter(
            onItemAdd = {
                handleClubDialog.show(parentFragmentManager, null)
            }
        )
        binding.selectClubRecyclerView.adapter = selectClubAdapter
        selectClubAdapter.initList(PrefManager.getClubList())
    }

    private fun initDialog() {
        handleClubDialog = HandleClubDialog(
            mode = MODE_ADD,
            onAddItem = {
                selectClubAdapter.addItemLast()
            }
        )
    }


}