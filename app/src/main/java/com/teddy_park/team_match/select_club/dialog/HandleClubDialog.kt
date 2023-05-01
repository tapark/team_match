package com.teddy_park.team_match.select_club.dialog

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.teddy_park.team_match.R
import com.teddy_park.team_match.base.BaseDialogFragment
import com.teddy_park.team_match.databinding.DialogHandleClubBinding
import com.teddy_park.team_match.util.PrefManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HandleClubDialog(
    val mode: Int,
    val onAddItem: () -> Unit
): BaseDialogFragment<DialogHandleClubBinding, HandleClubDialogViewModel>() {

    override val viewModel: HandleClubDialogViewModel by viewModels()
    override val layout: Int = R.layout.dialog_handle_club

    override var dialogWidthScale: Float = 0.65F

    override fun onBackPressed() {

    }

    override fun addObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
        binding.confirmButton.setOnClickListener {
            val clubList = PrefManager.getClubList()
            val clubItem = ClubItemInfo(
                name = binding.clubEditText.text.toString()
            )
            clubList.add(clubItem)
            PrefManager.setClubList(clubList)
            dismiss()
            onAddItem()
        }

    }

    companion object {
        const val MODE_ADD = 0
        const val MODE_MODIFY = 1
    }
}