package com.example.work2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.work2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy{ ActivityMainBinding.inflate(layoutInflater) }

        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        setContentView(binding.root)

        var dat = listOf("선택하세요","1월","2월","3월","4월","5월","6월")

        var adapter = ArrayAdapter<String>(this,R.layout.item_spinner,data)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.result.text = data[pos]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }


}