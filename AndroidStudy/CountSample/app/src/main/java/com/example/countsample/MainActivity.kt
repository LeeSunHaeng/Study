package com.example.countsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var count:Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countView= findViewById<TextView>(R.id.countView)
        val Pbtn = findViewById<Button>(R.id.Pbtn)
        val Mbtn = findViewById<Button>(R.id.Mbtn)
        val reset = findViewById<Button>(R.id.reset_btn)

        Pbtn.setOnClickListener {
            count++
            countView.text = count.toString()
        }
        Mbtn.setOnClickListener {
            count--
            countView.text = count.toString()
        }

        reset.setOnClickListener {
            count = 0
            countView.text = "0"
        }

        val editText = findViewById<EditText>(R.id.editText)
        val setBtn = findViewById<Button>(R.id.set_btn)

        setBtn.setOnClickListener {
            countView.text = editText.text.toString()
            count = editText.text.toString().toInt()
        }

    }
}