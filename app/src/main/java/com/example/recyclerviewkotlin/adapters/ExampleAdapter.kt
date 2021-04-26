package com.example.recyclerviewkotlin.adapters

import android.database.CursorIndexOutOfBoundsException
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.ExampleItem
import com.example.recyclerviewkotlin.R

class ExampleAdapter (private val exampleList: List<ExampleItem>):RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.appcent_items,
            parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageView.setImageResource(R.drawable.ic_launcher_background)
        holder.tvTitle.text = currentItem.title
        holder.tvDesc.text = currentItem.description
        holder.tvDate.text = currentItem.date

    }

    override fun getItemCount() = exampleList.size


    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView : ImageView = itemView.findViewById(R.id.vholder_items_img)
        val tvTitle:TextView = itemView.findViewById(R.id.vholder_items_tv_title)
        val tvDesc:TextView=itemView.findViewById(R.id.vholder_items_tv_desc)
        val tvDate:TextView=itemView.findViewById(R.id.vholder_items_tv_published)
    }
}