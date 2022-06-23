package com.example.sample35singleturn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextT)
        val moveBtn = findViewById<Button>(R.id.move)

        moveBtn.setOnClickListener {
            //싱글턴 변수 Chicken에 값 넣는법
            Singleton.chicken = editText.text.toString()

            val intent = Intent(this,SubActivity::class.java)
            startActivity(intent)
        }
    }
}


