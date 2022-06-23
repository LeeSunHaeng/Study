package com.example.sample36sqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dbHelper = DBHelper(this, "mydb.db",null,1)

        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val deleteBtn = findViewById<Button>(R.id.delBtn)
        val selectBtn = findViewById<Button>(R.id.selectBtn)

        val editInsert = findViewById<EditText>(R.id.editInsert)
        val editDelete = findViewById<EditText>(R.id.editDelText)

        val selectText = findViewById<TextView>(R.id.selectionText)
        var database = dbHelper.writableDatabase

        insertBtn.setOnClickListener {
            val txt = editInsert.text
            dbHelper.insert(database,txt.toString())
        }
        deleteBtn.setOnClickListener {
            val txt = editDelete.text
            dbHelper.delete(database,txt.toString().toInt())
        }
        selectBtn.setOnClickListener {
            selectText.text = dbHelper.select(database)
        }

    }
}