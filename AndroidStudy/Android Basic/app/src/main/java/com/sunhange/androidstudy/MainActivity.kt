package com.sunhange.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunhange.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit = 초기화를 늦추는
    //코틀린에서 초기화란 값을 집어넣는 행위로 볼 수 있다.
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName2.setText("안녕하세요 이선행 입니다.")
        binding.tvContent.setText("기본공부 확실히")

        //findViewById <-원래는 이걸 써야했는데 viewBinding을 사용하면 사용하지 않아도 됨


        //액티비티가 생성될 때 호출되어 사용자 인터페이스 초기화 할 때 이곳에 구현
        println("sunhangLee onCreate!!")

    }

    override fun onStart() {
        super.onStart()
        //액티비티가 사용자에게 보여지기 직전에 호출됨
        println("sunhangLee onStart!!")
    }

    override fun onResume() {
        super.onResume()
        //액티비티가 사용자랑 상호작용 하기 직전에 호출 됨. (시작 or 재개 상태)
        println("sunhangLee onResume!!")
    }

    override fun onPause() {
        super.onPause()
        //다른 액티비티가 보여지게 될 때 호출됨.(중지 상태)
        println("sunhangLee onPause!!")
    }

    override fun onStop() {
        super.onStop()
        //액티비티가 사용자에게 완전히 보여지지 않을 때 호출됨.
        println("sunhangLee onStop!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        //액티비티가 소멸(제거)될 때 호출됨.
        println("sunhangLee onDestroy!!")
    }

    override fun onRestart() {
        super.onRestart()
        //액티비티가 멈추었다가 다시 시작되기 전에 호출됨.
        println("sunhangLee onRestart!!")
    }
}