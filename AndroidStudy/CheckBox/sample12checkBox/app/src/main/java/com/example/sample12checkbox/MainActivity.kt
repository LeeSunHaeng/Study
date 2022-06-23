package com.example.sample12checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import com.example.sample12checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        binding.checkBox.setOnCheckedChangeListener(checklistener)
    }

    val checklistener by lazy {
        CompoundButton.OnCheckedChangeListener(){ buttonView, isChecked ->
            val checkBox = findViewById<CheckBox>(R.id.checkBox)
            val textView = findViewById<TextView>(R.id.textView)

            if(isChecked){
                when(buttonView.id){
                    R.id.checkBox ->{
                        textView.text = "체크됨"
                    }
                }
            }
            else{
                when(buttonView.id){
                    R.id.checkBox ->{
                        textView.text = "체크해제됨"
                    }
                }

            }


        }
    }

}