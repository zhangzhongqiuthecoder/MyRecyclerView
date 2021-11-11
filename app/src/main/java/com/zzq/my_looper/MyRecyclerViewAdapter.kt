package com.zzq.my_looper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    var items: List<String>,
    val onItemBind: (holder: MyViewHolder, position: Int) -> Unit
) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLog: TextView = itemView.findViewById(R.id.tvLog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        onItemBind.invoke(holder, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(data: List<String>) {
        this.items = data
        notifyDataSetChanged()
    }
}