package com.example.work4bingo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val setBtn = findViewById<Button>(R.id.setBtn)
        val startBtn = findViewById<Button>(R.id.startBtn)
        var num = ""
        spinner.adapter = ArrayAdapter.createFromResource(this,R.array.numList,android.R.layout.simple_spinner_item)
        setBtn.setOnClickListener {

            num = spinner.selectedItem.toString()

        }

        startBtn.setOnClickListener {
          val nextIntent = Intent(this,SubActivity::class.java)
            nextIntent.putExtra("numKey",num)
            Toast.makeText(this,"$num",Toast.LENGTH_SHORT).show()
            startActivity(nextIntent)

        }


        }

    }

