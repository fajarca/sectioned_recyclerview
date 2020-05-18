package io.fajarca.project.sectionedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.fajarca.project.sectionedrecyclerview.R

class ItemAdapter(private val items : List<String>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        companion object {
            fun create(parent: ViewGroup) : ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
                return ViewHolder(
                    view
                )
            }
        }

        fun bind(itemName : String) {
            val tvItemName= view.findViewById(R.id.tvItemName) as TextView
            val ivItemPicture = view.findViewById(R.id.ivItemPicture) as ImageView

            tvItemName.text = itemName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(
            parent
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size


}