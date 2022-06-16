package com.sunhange.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunhange.viewmodel_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

    companion object{
        private const val TAG:String = "로그"
    }

    //나중에 값이 설정 되도록
    lateinit var myNumberViewModel: MyNumberViewModel
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPlus.setOnClickListener(this)
        binding.btMinus.setOnClickListener(this)

        //뷰 모델 프로바이더를 통해 뷰 모델 가져오기
        //라이프 사이클을 가지고 있는 녀석을 넣어줌, 즉 자기 자신
        //우리가 가져오고 싶은 뷰 모델 클래스를 넣어서 뷰모델 가져오기
        myNumberViewModel = ViewModelProvider(this)[MyNumberViewModel::class.java]

        //뷰 모델이 가지고 있는 값의 변경사항을 관찰할 수 있는 라이브 데이터를 옵저빙 한다.
        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG,"MainActivity - myNumberViewModel - currentValue 라이브 데이터 값 변경 : $it")
            binding.tvPrint.text = it.toString()
        })

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btPlus -> {
                myNumberViewModel.updateValue(actionType = ActionType.PLUS,binding.etNumber.text.toString().toInt())
                Log.d(TAG,"MainActivity - 플러스 버튼 터치 ${binding.etNumber.text.toString().toInt()}")
            }

            binding.btMinus -> {
                myNumberViewModel.updateValue(actionType = ActionType.MINUS,binding.etNumber.text.toString().toInt())
                Log.d(TAG,"MainActivity - 마이너스 버튼 터치 ${binding.etNumber.text.toString().toInt()}")
            }
        }
    }

}