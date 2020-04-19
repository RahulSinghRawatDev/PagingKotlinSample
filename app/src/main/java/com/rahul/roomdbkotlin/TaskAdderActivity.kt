package com.rahul.roomdbkotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_task_adder2.*

class TaskAdderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_adder2)
        btnSave.setOnClickListener {
            val replyIntent = intent
            if (TextUtils.isEmpty(edTaskName.text)||TextUtils.isEmpty(edTaskDescription.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }else{
                val taskName = edTaskName.text.toString()
                val taskDescription = edTaskDescription.text.toString()
                replyIntent.putExtra("TASKNAME",taskName)
                replyIntent.putExtra("TASKDESC",taskDescription)
                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }


    }
}
