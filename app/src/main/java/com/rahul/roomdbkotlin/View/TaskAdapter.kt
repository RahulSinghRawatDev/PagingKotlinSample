package com.rahul.roomdbkotlin.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahul.roomdbkotlin.Entity.Task
import com.rahul.roomdbkotlin.R

class TaskAdapter internal constructor(context: Context):RecyclerView.Adapter<TaskAdapter.ViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var task = emptyList<Task>() // Cached copy of tasks

    inner class ViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {
        val wordItemView: TextView = itemView.findViewById(R.id.textName)
        val wordDesc: TextView = itemView.findViewById(R.id.textDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ViewHolder {
        val itemView = inflater.inflate(R.layout.taskadapterlayout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return task.size
    }

    internal fun setWords(task: List<Task>) {
        this.task = task
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        val current = task[position]
        holder.wordItemView.text = current.taskName
        holder.wordDesc.text = current.taskDescription

    }

}