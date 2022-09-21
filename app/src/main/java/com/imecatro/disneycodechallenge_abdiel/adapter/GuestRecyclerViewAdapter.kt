package com.imecatro.disneycodechallenge_abdiel.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.imecatro.disneycodechallenge_abdiel.databinding.FragmentItemBinding
import com.imecatro.disneycodechallenge_abdiel.model.Guest


class GuestRecyclerViewAdapter(
    private val values: List<Guest>,
    private val clickAction: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<GuestRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.checkBoxView.isChecked = item.guestCheck
        holder.guestName.text = item.guestName

        holder.itemView.setOnClickListener {
            clickAction(position, !holder.checkBoxView.isChecked)
            holder.checkBoxView.isChecked = !holder.checkBoxView.isChecked
        }
        holder.checkBoxView.setOnClickListener {
            clickAction(position, holder.checkBoxView.isChecked)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val checkBoxView: CheckBox = binding.guestCheckbox
        val guestName: TextView = binding.guestName

        override fun toString(): String {
            return super.toString() + " '" + guestName.text + "'"
        }
    }

}