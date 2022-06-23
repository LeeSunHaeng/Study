package com.example.favouritelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(this,"mydb.db",null,1)
        val database = dbHelper.writableDatabase
        var insertBtn = findViewById<Button>(R.id.insertBtn)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        insertBtn.setOnClickListener {

            var intent = Intent(this,insertActivity::class.java)
            startActivity(intent)
        }
        val data:MutableList<Favourite> =dbHelper.main(database)
        var adapter = CustomAdapter(this,data)
        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
    }
}