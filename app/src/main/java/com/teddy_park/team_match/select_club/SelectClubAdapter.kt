package com.teddy_park.team_match.select_club

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teddy_park.team_match.databinding.ItemAddClubBinding
import com.teddy_park.team_match.databinding.ItemSelectClubBinding

class SelectClubAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val clubList = mutableListOf<String>()

    inner class SelectClubViewHolder(val binding: ItemSelectClubBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String, position: Int) {

        }
    }

    inner class AddClubViewHolder(val binding: ItemAddClubBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == CLUB_ITEM) {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = ItemSelectClubBinding.inflate(layoutInflater, parent, false)
            return SelectClubViewHolder(view, parent.context)
        } else {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = ItemAddClubBinding.inflate(layoutInflater, parent, false)
            return AddClubViewHolder(view)
        }
    }

    override fun getItemCount(): Int = clubList.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == clubList.size) {
            (holder as AddClubViewHolder).bind()
        } else {
            (holder as SelectClubViewHolder).bind(clubList[position], position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == clubList.size) {
            LAST_ADD_ITEM
        } else {
            CLUB_ITEM
        }
    }


    companion object {
        const val CLUB_ITEM = 1
        const val LAST_ADD_ITEM = 0
    }
}