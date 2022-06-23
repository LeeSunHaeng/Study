package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.favouritelist.CustomAdapter
import com.example.favouritelist.DBHelper

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val recyclerView = findViewById<RecyclerView>(R.id.searchRecyclerView)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)
        val searchEditText = findViewById<EditText>(R.id.searchEditText)


        val dbHelber = DBHelper(this,"mydb.db",null,1)
        val database = dbHelber.writableDatabase

        searchBtn.setOnClickListener {
            println("searchBtn 클릭!")
            val data:MutableList<AddressDto> =dbHelber.search(database,searchEditText.text.toString())
            println(data.get(0).name.toString())

            var adapter = CustomAdapter(this,data)
            recyclerView.adapter = adapter

            val layout = LinearLayoutManager(this)
            recyclerView.layoutManager = layout
            recyclerView.setHasFixedSize(true)
        }
        deleteBtn.setOnClickListener {

            dbHelber.delete(database,searchEditText.text.toString())
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)

        }

    }
}