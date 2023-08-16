package com.example.alomoves.ui.fragments.classes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alomoves.data.models.GymClassesItem
import com.example.alomoves.databinding.TicketClassesBinding

class ClassesAdapter(private val clickListener: (gymClassesData: GymClassesItem) -> Unit) :
    ListAdapter<GymClassesItem, ClassesAdapter.ClassesViewHolder>(DiffCallback) {
    private companion object DiffCallback : DiffUtil.ItemCallback<GymClassesItem>() {
        override fun areItemsTheSame(
            oldItem: GymClassesItem, newItem: GymClassesItem,
        ): Boolean {
            return oldItem.classesTitle == newItem.classesTitle
        }

        override fun areContentsTheSame(
            oldItem: GymClassesItem, newItem: GymClassesItem,
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        return ClassesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val item = getItem(position)
        holder.also {
            it.itemView.setOnClickListener {
                clickListener(item)
            }
            it.bind(item)
        }
    }

    class ClassesViewHolder(private val binding: TicketClassesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ClassesViewHolder {
                return ClassesViewHolder(
                    TicketClassesBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ),
                        parent,
                        false
                    )
                )
            }
        }

        fun bind(gymClassesData: GymClassesItem) {
            binding.classesData = gymClassesData
            binding.executePendingBindings()
        }
    }
}