package com.example.work3bball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val list = mutableListOf<Int>()
    var ball = 0
    var strike = 0
    val spinner1 = findViewById<Spinner>(R.id.spinner1)
    val spinner2 = findViewById<Spinner>(R.id.spinner2)
    val spinner3 = findViewById<Spinner>(R.id.spinner3)
    val spc1: TextView = findViewById<TextView>(R.id.spcheck1)
    val spc2 : TextView = findViewById<TextView>(R.id.spcheck2)
    val spc3: TextView  = findViewById<TextView>(R.id.spcheck3)
    val sbText : TextView = findViewById<TextView>(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random = Random(9)


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

        spinner2.adapter = ArrayAdapter.createFromResource(this, R.array.numList, android.R.layout.simple_spinner_item)
        spinner2.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position){
                    0 ->spc2.text = "0"
                    1 ->spc2.text = "1"
                    2 ->spc2.text = "2"
                    3 ->spc2.text = "3"
                    4 ->spc2.text = "4"
                    5 ->spc2.text = "5"
                    6 ->spc2.text = "6"
                    7 ->spc2.text = "7"
                    8 ->spc2.text = "8"
                    9 ->spc2.text = "9"

                }

            }

        }

        spinner3.adapter = ArrayAdapter.createFromResource(this, R.array.numList, android.R.layout.simple_spinner_item)
        spinner3.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position){
                    0 ->spc3.text = "0"
                    1 ->spc3.text = "1"
                    2 ->spc3.text = "2"
                    3 ->spc3.text = "3"
                    4 ->spc3.text = "4"
                    5 ->spc3.text = "5"
                    6 ->spc3.text = "6"
                    7 ->spc3.text = "7"
                    8 ->spc3.text = "8"
                    9 ->spc3.text = "9"

                }

            }



        }

        //랜덤넘버 중복x 생성, set에 담기
        while(list.size<4){
            var randomNum = random.nextInt(9)
            if(list.size == 0 && randomNum==0){
                continue
            }else if(list.contains(randomNum)){
                list.add(randomNum)
            }
        }

    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                //set과 spinner 값 비교해서 ball strike 구분하기
                //첫번째 자리수 검사
               R.id.playButton -> {
                   if (list.contains(Integer.parseInt(spc1.text as String))) {
                       if (list[0].equals(spc1.text)) {
                           strike++
                       } else {
                           ball++
                       }
                   }
                   //두번째 자리수 검사
                   if (list.contains(Integer.parseInt(spc2.text as String))) {
                       if (list[1].equals(spc2.text)) {
                           strike++
                       } else {
                           ball++
                       }
                   }
                   //세번째 자리수 검사
                   if (list.contains(Integer.parseInt(spc3.text as String))) {
                       if (list[2].equals(spc3.text)) {
                           strike++
                       } else {
                           ball++
                       }
                   }

                   sbText.text = "$ball ball $strike strike 입니다."
               }
            }
        }
    }
}