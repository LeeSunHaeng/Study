package com.example.work7accountbookfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.work7accountbookfinal.insertActivity
import com.example.work7accountbookfinal.searchActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val dateSearchBtn = findViewById<Button>(R.id.dateSearchBtn)

        insertBtn.setOnClickListener {
            val intent= Intent(this, insertActivity::class.java)
            startActivity(intent)
        }
        searchBtn.setOnClickListener {
            val intent= Intent(this, searchActivity::class.java)
            startActivity(intent)
        }
        dateSearchBtn.setOnClickListener {
            val intent= Intent(this, PeriodSearchActivity::class.java)
            startActivity(intent)
        }
    }
}