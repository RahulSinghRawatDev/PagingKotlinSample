package com.rahul.roomdbkotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rahul.roomdbkotlin.Dao.TaskDao
import com.rahul.roomdbkotlin.Entity.Task

@Database(entities = arrayOf(Task::class),version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun taskDao():TaskDao

    companion object{
        private var INSTANCE : AppDatabase?=null

        fun getDatabase(context:Context):AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                                AppDatabase::class.java,"TaskDatabase")
                    .build()
                INSTANCE = instance
                return instance
            }
        }

/*        fun getCacheDatabase(context:Context):AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(this){
                val instance = Room.inMemoryDatabaseBuilder(context.applicationContext,
                        AppDatabase::class.java)
                    .build()
                INSTANCE = instance
                return instance
            }
        }*/
    }
}