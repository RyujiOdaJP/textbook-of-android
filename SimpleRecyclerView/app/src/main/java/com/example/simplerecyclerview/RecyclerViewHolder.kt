package com.example.simplerecyclerview

import android.telecom.Call
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    interface ItemClickListener {
        fun onItemClick(itemView: View, position: Int)
    }
    var titleView: TextView = itemView.findViewById(R.id.title)
    var detailView: TextView = itemView.findViewById(R.id.detail)

    init {

    }
}