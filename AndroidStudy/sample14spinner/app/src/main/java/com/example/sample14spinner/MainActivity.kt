package com.example.sample14spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //val fruit = arrayOf("과일 선택","사과","배","바나나","포도")
@Override
    override fun onCreate(savedInstanceState: Bundle?) {
        val fruit = resources.getStringArray(R.array.fruit)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinnerFruit()
        setupSinnerHandler()
    }
    //Spinner에 값을 설정
    fun setupSpinnerFruit(){
        //어댑터에 배열과 xml을 적용해줌
        val adapter = ArrayAdapter(this,R.layout.item_spinner, fruit)



        //spinner에 적용
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter
    }
    //Spinner를 선택시 결과를 출력해주는 함수수
    fun setupSinnerHandler(){

    val spinner = findViewById<Spinner>(R.id.spinner)
    val textView = findViewById<TextView>(R.id.textView)

    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
           textView.text = "선택됨 : $position ${spinner.getItemAtPosition(position)}"
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }
    }
    }
}