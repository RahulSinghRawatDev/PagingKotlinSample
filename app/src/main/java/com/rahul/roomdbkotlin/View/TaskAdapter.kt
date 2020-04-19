package com.rahul.roomdbkotlin.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahul.roomdbkotlin.Entity.Task
import com.rahul.roomdbkotlin.R

class TaskAdapter internal constructor(context: Context):PagedListAdapter<Task,TaskAdapter.ViewHolder>(REPO_COMPARATOR){


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var task = emptyList<Task>() // Cached copy of tasks


    class ViewHolder(parent :ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.taskadapterlayout, parent, false)) {

        val taskName: TextView = itemView.findViewById(R.id.textName)
        val taskDescription: TextView = itemView.findViewById(R.id.textDescription)
        val taskId: TextView = itemView.findViewById(R.id.textID)

        var task : Task? = null



        /**
         * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
         * ViewHolder when Item is loaded.
         */
        fun bindTo(task : Task?) {
            this.task = task
            taskName.text = task?.taskName
            taskDescription.text = task?.taskDescription
            taskId.text = task?.taskId.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)


    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        val data : Task? = getItem(position)
        holder.bindTo(data)
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
                oldItem.taskId == newItem.taskId
            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
                oldItem == newItem
        }
    }
}