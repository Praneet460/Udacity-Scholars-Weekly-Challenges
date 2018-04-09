package com.slack.weeklychallengeone.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slack.weeklychallengeone.R
import kotlinx.android.synthetic.main.row_layout.view.*
import java.util.*

class MyAdapter(private val mArrayList: ArrayList<Model>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = mArrayList[position].name
        holder.description.text = mArrayList[position].description
        holder.foldingCell.setOnClickListener {
            holder.foldingCell.toggle(false)
        }
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }


    inner class MyViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.tv_name!!
        var description = itemView.tv_description!!
        var foldingCell = itemView.folding_cell!!
    }
}
