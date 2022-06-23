package com.example.work7accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val dateSearchBtn = findViewById<Button>(R.id.dateSearchBtn)

        insertBtn.setOnClickListener {
           val intent= Intent(this,insertActivity::class.java)
            startActivity(intent)
        }
    }
}