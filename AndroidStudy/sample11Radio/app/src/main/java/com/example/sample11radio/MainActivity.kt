package com.example.sample11radio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val textView = findViewById<TextView>(R.id.textView)

        radioGroup.setOnCheckedChangeListener{_,checkedId->
            when(checkedId){

                R.id.radio1 -> textView.text = "사과입니다."
                R.id.radio2 -> textView.text = "바나나입니다."
                R.id.radio3 -> textView.text = "오렌지입니다."
            }
        }


    }
}