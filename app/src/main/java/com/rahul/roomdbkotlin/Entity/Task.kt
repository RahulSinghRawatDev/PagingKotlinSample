package com.rahul.roomdbkotlin.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val taskId : Int,
    @ColumnInfo(name = "taskName")
    val taskName:String,
    @ColumnInfo(name = "taskDescription")
    val taskDescription:String)