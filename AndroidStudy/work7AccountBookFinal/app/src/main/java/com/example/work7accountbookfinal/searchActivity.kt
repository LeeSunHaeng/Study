package com.example.work7accountbookfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class searchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val searchStartBtn = findViewById<Button>(R.id.searchStartBtn)
        val searchMainBtn = findViewById<Button>(R.id.searchMaintBtn)

        val dbHelper:DBHelper = DBHelper(this,"mydb.db",null,1)
        var database = dbHelper.writableDatabase

        searchStartBtn.setOnClickListener {
            val datePicker = findViewById<DatePicker>(R.id.searchDatePicker)
            var year = datePicker.year
            var month = datePicker.month
            var day = datePicker.dayOfMonth
            var date = String.format("%d-%02d-%02d", year,month+1,day)

            val data:MutableList<Account> =dbHelper.search(database,date)
            var adapter = CustomAdapter(this,data)
            recyclerView.adapter = adapter

            val layout = LinearLayoutManager(this)
            recyclerView.layoutManager = layout
            recyclerView.setHasFixedSize(true)


        }

        searchMainBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}