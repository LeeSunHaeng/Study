package com.example.work7accountbookfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PeriodSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_period_search)
        val periodSearchBtn = findViewById<Button>(R.id.periodBtn)
        val dbHelper:DBHelper = DBHelper(this,"mydb.db",null,1)
        var database = dbHelper.writableDatabase
        val periodRecyclerView = findViewById<RecyclerView>(R.id.periodRecyclerView)

        val periodMainBtn = findViewById<Button>(R.id.periodMainBtn)

        periodSearchBtn.setOnClickListener {
            val startDatePicker = findViewById<DatePicker>(R.id.StartDatePicker)
            var startYear = startDatePicker.year
            var startMonth = startDatePicker.month
            var startDay = startDatePicker.dayOfMonth
            var startDate = String.format("%d-%02d-%02d", startYear,startMonth+1,startDay)

            val endDatePicker = findViewById<DatePicker>(R.id.EndDatePicker)
            var endYear = endDatePicker.year
            var endMonth = endDatePicker.month
            var endDay = endDatePicker.dayOfMonth
            var endDate = String.format("%d-%02d-%02d", endYear,endMonth+1,endDay)

            val PeriodData:MutableList<Account> =dbHelper.periodSearch(database,startDate,endDate)
            var PeriodAdapter = CustomAdapter(this,PeriodData)
            periodRecyclerView.adapter = PeriodAdapter

            val PeriodLayout = LinearLayoutManager(this)
            periodRecyclerView.layoutManager = PeriodLayout
            periodRecyclerView.setHasFixedSize(true)


        }

        periodMainBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}