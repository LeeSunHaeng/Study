package com.example.sample34intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editName = findViewById<EditText>(R.id.editName)
        val editCount = findViewById<EditText>(R.id.editCount)
        val editLevel = findViewById<EditText>(R.id.editLevel)
        val moveBtn = findViewById<Button>(R.id.move)

        moveBtn.setOnClickListener {
           var student = student(editName.text.toString(),editCount.text.toString().toInt(),editLevel.text.toString())

            val nextIntent = Intent(this,SecondActivity::class.java)
            nextIntent.putExtra("student",student)
            startActivity(nextIntent)
        }
    }

    override fun onClick(view: View?) {

    }
}