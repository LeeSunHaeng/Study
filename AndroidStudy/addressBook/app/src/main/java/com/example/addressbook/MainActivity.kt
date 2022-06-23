package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.favouritelist.CustomAdapter
import com.example.favouritelist.DBHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DBHelper(this,"mydb.db", null,1)
        val database = dbHelper.writableDatabase

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val insertChangeBtn = findViewById<Button>(R.id.insertChangeBtn)

        val searchChangeBtn = findViewById<Button>(R.id.searchChangeBtn)


        searchChangeBtn.setOnClickListener {
            val i = Intent(this,SearchActivity::class.java)
            startActivity(i)
        }

        insertChangeBtn.setOnClickListener {
            val i = Intent(this,insertActivity::class.java)
            startActivity(i)
            println("insert버튼 누름")
        }

        val data:MutableList<AddressDto> = dbHelper.main(database)

        var adapter = CustomAdapter(this,data)
        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)


    }
}