package com.rahul.roomdbkotlin.View

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rahul.roomdbkotlin.Entity.Task
import com.rahul.roomdbkotlin.R
import com.rahul.roomdbkotlin.TaskAdderActivity
import com.rahul.roomdbkotlin.ViewModel.TaskViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val adapter = TaskAdapter(this)
        recyclerview.adapter = adapter

        taskViewModel.allTasks.observe(this, Observer {
            Log.i("Main","observe.............."+it)
            Log.i("Main","observ//////////e"+it.size)
            adapter.submitList(it)
        })

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, TaskAdderActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            val task = Task(0, data?.getStringExtra("TASKNAME").toString(),
                data?.getStringExtra("TASKDESC").toString()
            )

            taskViewModel.insertTask(task)

        }else {
            Toast.makeText(
                applicationContext,
                "Please fill both the details",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}
