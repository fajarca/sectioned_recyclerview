package io.fajarca.project.sectionedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.fajarca.project.sectionedrecyclerview.R
import io.fajarca.project.sectionedrecyclerview.data.RecyclerViewSection
import io.fajarca.project.sectionedrecyclerview.data.RecyclerViewType

class ContainerAdapter(private val context: Context, private val sections : List<RecyclerViewSection>, private val recyclerViewType: RecyclerViewType) : RecyclerView.Adapter<ContainerAdapter.ViewHolder>() {

    class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        companion object {
            fun create(parent: ViewGroup) : ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content_container, parent, false)
                return ViewHolder(
                    view
                )
            }
        }

        fun bind(context : Context, section : RecyclerViewSection, recyclerViewType: RecyclerViewType) {
            val tvName = view.findViewById(R.id.tvSectionName) as TextView
            val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

            tvName.text = section.label
            recyclerView.setHasFixedSize(true)
            recyclerView.isNestedScrollingEnabled = false

             when(recyclerViewType) {
                 RecyclerViewType.LINEAR_VERTICAL -> {
                     val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                     recyclerView.layoutManager = layoutManager
                 }
                RecyclerViewType.LINEAR_HORIZONTAL -> {
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    recyclerView.layoutManager = layoutManager
                }
                RecyclerViewType.GRID -> {
                    val layoutManager = GridLayoutManager(context, 3)
                    recyclerView.layoutManager = layoutManager
                }
            }

            val adapter =
                ItemAdapter(
                    section.items
                )
            recyclerView.adapter = adapter

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(
            parent
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val section = sections[position]
        holder.bind(context, section, recyclerViewType)
    }

    override fun getItemCount() = sections.size


}