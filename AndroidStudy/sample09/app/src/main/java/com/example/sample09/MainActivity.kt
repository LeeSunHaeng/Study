package com.example.sample09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sample09.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn2.setOnClickListener {
            Toast.makeText(this.applicationContext, "버튼1 클릭", Toast.LENGTH_SHORT).show()
        }
      /*  setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            Toast.makeText(this.applicationContext, "버튼1 클릭", Toast.LENGTH_SHORT).show()
        }*/
    }

   /* override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn2 ->{
                Log.d("버튼","클릭")

                var btn1 = findViewById<Button>(R.id.btn1)
                btn1.text = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date())
            }
        }
    }*/
}