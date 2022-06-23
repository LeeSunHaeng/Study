package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.favouritelist.DBHelper

class insertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val nameEdit = findViewById<EditText>(R.id.nameEditText)
        val ageEdit = findViewById<EditText>(R.id.ageEditText)
        val relativeEdit = findViewById<EditText>(R.id.relativeEditText)
        val jobEdit = findViewById<EditText>(R.id.jobEditText)
        val addressEdit = findViewById<EditText>(R.id.addressEditText)
        val phoneNumberEdit = findViewById<EditText>(R.id.phoneNumberEditText)

        val insertBtn = findViewById<Button>(R.id.insertBtn)

        val dbHelper = DBHelper(this,"mydb.db",null,1)
        val database = dbHelper.writableDatabase

        insertBtn.setOnClickListener {

            val address = AddressDto(nameEdit.text.toString(),ageEdit.text.toString().toInt(),relativeEdit.text.toString()
            ,jobEdit.text.toString(),addressEdit.text.toString(),phoneNumberEdit.text.toString())

            dbHelper.insert(database,address)

            val i = Intent(this,MainActivity::class.java)
            startActivity(i)

        }

    }
}