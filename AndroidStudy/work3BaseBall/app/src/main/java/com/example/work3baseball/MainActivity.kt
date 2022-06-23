package com.example.work3baseball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)
        val spc1 = findViewById<TextView>(R.id.spcheck1)

        spinner1.adapter = ArrayAdapter.createFromResource(this, R.array.numList, android.R.layout.simple_spinner_item)
        spinner1.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(position){
                0 ->spc1.text = "0"
                1 ->spc1.text = "1"
                2 ->spc1.text = "2"
                3 ->spc1.text = "3"
                4 ->spc1.text = "4"
                5 ->spc1.text = "5"
                6 ->spc1.text = "6"
                7 ->spc1.text = "7"
                8 ->spc1.text = "8"
                9 ->spc1.text = "9"

            }

            }



        }
    }
}