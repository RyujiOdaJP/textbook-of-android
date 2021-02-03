package com.example.simplerecyclerview

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val context: Context,
    private val itemClickListener: RecyclerViewHolder.ItemClickListener,
    private val itemList: List<String>
) : RecyclerView.Adapter<RecyclerViewHolder>(){
    private var mRecyclerView : RecyclerView? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
