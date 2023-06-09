package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CoursesAdapter(datalist: List<DataItem>, listener: Listener) : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    private var dataList: List<DataItem> = datalist
    private var listener = listener
    //private var dataList: List<String> = datalist

    override fun getItemCount(): Int {
        return this.dataList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageItem: ImageView = itemView.findViewById(R.id.imageView)
        val textItem: TextView = itemView.findViewById(R.id.textView)

        fun listenOnClick(dataItem: DataItem, position: Int, listener: Listener) {
            itemView.setOnClickListener {
                listener.onCLick(dataItem);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return CourseViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.imageItem.setImageResource(dataList[position].src)
        holder.textItem.text = dataList[position].text
        holder.listenOnClick(dataList[position], position, listener)
    }

    interface Listener {
        fun onCLick(dataItem: DataItem)
    }
}