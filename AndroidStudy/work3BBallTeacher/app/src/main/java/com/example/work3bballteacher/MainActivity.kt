package com.example.work3bballteacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner(R.id.spinner1)
        setupSpinner(R.id.spinner2)
        setupSpinner(R.id.spinner3)
    }

    //spinner
    fun setupSpinner(spinnerNum:Int){
        var countArr = arrayListOf(1,2,3,4,5,6,7,8,9,10)

        val adapter = ArrayAdapter(this,R.layout.item_spinner,countArr)

        val spinner = findViewById<Spinner>(spinnerNum)
        spinner.adapter = adapter
    }
}