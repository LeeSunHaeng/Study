package com.example.work5regi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class insertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val insertBtn = findViewById<Button>(R.id.insert)

        val insertName = findViewById<EditText>(R.id.insertName)
        val insertAge = findViewById<EditText>(R.id.insertAge)
        val insertAddress = findViewById<EditText>(R.id.insertAddress)

        insertBtn.setOnClickListener {
            val mem = Member(0,insertName.text.toString(),
                                    insertAge.text.toString().toInt(),
                                    insertAddress.text.toString())

            val dbHelper = DBHelper.getInstance(this, "member.db")


        }

    }
}