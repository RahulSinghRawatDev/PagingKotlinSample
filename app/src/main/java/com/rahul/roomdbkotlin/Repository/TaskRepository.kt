package com.rahul.roomdbkotlin.Repository
import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.DataSource
import androidx.paging.toLiveData
import com.rahul.roomdbkotlin.Dao.TaskDao
import com.rahul.roomdbkotlin.Entity.Task

class TaskRepository(val taskDao: TaskDao){

    // val allTasks : LiveData<List<Task>> = taskDao.getAllTask().create()

    val allTasks : DataSource.Factory<Int,Task> = taskDao.getAllTask()
    val taskList  = allTasks.toLiveData(Config(pageSize = 4,enablePlaceholders = false,maxSize = 12))

    suspend fun insertTask(task: Task){
        taskDao.insertTask(task)
    }
}