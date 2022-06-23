package com.example.work7accountbookfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup

class insertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val radio = findViewById<RadioGroup>(R.id.radioGroup)
        var radioInt:Int = 0
        val title = findViewById<EditText>(R.id.editTextTitle)

        val money = findViewById<EditText>(R.id.editTextMoney)
        val memo = findViewById<EditText>(R.id.editTextMemo)

        val insertBtn = findViewById<Button>(R.id.inserCheckBtn)
        val mainBtn = findViewById<Button>(R.id.changeMainBtn)
        val dbHelper:DBHelper = DBHelper(this,"mydb.db",null,1)
        var database = dbHelper.writableDatabase

        insertBtn.setOnClickListener {
            val datePicker = findViewById<DatePicker>(R.id.EndDatePicker)
            var year = datePicker.year
            var month = datePicker.month
            var day = datePicker.dayOfMonth
            var date = String.format("%d-%02d-%02d", year,month+1,day)

            val account:Account = Account(0,radioInt,title.text.toString(),
                date, money.text.toString().toInt(), memo.text.toString())
            dbHelper.insert(database,account)
            val mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }
        radio.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.plusBtn -> radioInt = 1
                R.id.minusBtn -> radioInt = -1

            }

        }

        mainBtn.setOnClickListener {
            val nextIntent = Intent(this,MainActivity::class.java)
            startActivity(nextIntent)
        }


    }
}