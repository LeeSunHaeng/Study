package com.example.androidwork1counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var count:Int = 0
    private var countViewT:TextView = findViewById<TextView>(R.id.countView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(view: View?) {

            when (view?.id) {
                R.id.Pbtn -> {
                    count++
                    countViewT.text = count.toString()
                }
                R.id.Mbtn -> {
                    count--
                    countViewT.text = count.toString()
                }

        }
    }
}