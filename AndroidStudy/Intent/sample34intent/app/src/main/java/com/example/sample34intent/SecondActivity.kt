package com.example.sample34intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val read = findViewById<Button>(R.id.read)
        val text = findViewById<TextView>(R.id.textView)

        read.setOnClickListener {
            var student = intent.getParcelableExtra<student>("student")
            if(student!=null){
                text.text="${student.name} ${student.count} ${student.level}"
            }
        }

    }
}