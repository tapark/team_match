package com.teddy_park.team_match.ui.select_club.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teddy_park.team_match.databinding.ItemAddClubBinding
import com.teddy_park.team_match.databinding.ItemSelectClubBinding
import com.teddy_park.team_match.model.ClubInfo
import com.teddy_park.team_match.util.PrefManager

class SelectClubAdapter(
    val onItemAdd: () -> Unit,
    val onItemClick: (ClubInfo) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val clubList = mutableListOf<ClubInfo>()

    inner class SelectClubViewHolder(val binding: ItemSelectClubBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ClubInfo, position: Int) {

            binding.clubTextView.text = item.name
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    inner class AddClubViewHolder(val binding: ItemAddClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener {
                onItemAdd()
            }
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

    fun initList(init: List<ClubInfo>) {
        clubList.clear()
        clubList.addAll(init)
        notifyDataSetChanged()
    }

    fun updateList(position: Int) {
        clubList.clear()
//        subQuestList.addAll(PrefManager.getSubQuestList())
        notifyItemChanged(position)
//        notifyDataSetChanged()
    }

    fun addItemLast(clubInfo: ClubInfo) {
        clubList.add(clubInfo)
        notifyItemInserted(clubList.size - 1)
    }

    fun deleteItem(position: Int) {
        clubList.clear()
//        subQuestList.addAll(PrefManager.getSubQuestList())
        notifyItemRemoved(position)
    }



    companion object {
        const val CLUB_ITEM = 1
        const val LAST_ADD_ITEM = 0
    }
}