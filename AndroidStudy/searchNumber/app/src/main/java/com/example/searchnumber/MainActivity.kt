package com.example.searchnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ckText = findViewById<TextView>(R.id.textView)
        val inputText = findViewById<EditText>(R.id.editText)
        val btn = findViewById<Button>(R.id.button)

        val range = (1..99).random()


        btn.setOnClickListener {
            if(inputText.text.toString().toInt() > range) {
                ckText.text = "너무 큽니다."
                println("너무 큽니다.")
            }else if(inputText.text.toString().toInt() < range){
                ckText.text = "너무 작습니다."
                println("너무 작습니다.")
            }else{
                ckText.text = "정답입니다."
                println("정답입니다.")
            }
        }
    }
}