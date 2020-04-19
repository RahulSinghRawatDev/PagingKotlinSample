package com.rahul.roomdbkotlin.Repository
import androidx.lifecycle.LiveData
import com.rahul.roomdbkotlin.Dao.TaskDao
import com.rahul.roomdbkotlin.Entity.Task

class TaskRepository(val taskDao: TaskDao){

    val allTasks : LiveData<List<Task>> = taskDao.getAllTask()

    suspend fun insertTask(task: Task){
        taskDao.insertTask(task)
    }
}