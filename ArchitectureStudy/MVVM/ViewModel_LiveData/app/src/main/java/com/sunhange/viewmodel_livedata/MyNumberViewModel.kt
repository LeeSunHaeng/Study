package com.sunhange.viewmodel_livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//열거 클래스
//내부의 각각의 상수(constant)들은 오브젝트이다.
enum class ActionType{
    PLUS,MINUS
}

//데이터의 변경
//뷰 모델은 데이터의 변경사항을 알려주는 라이브데이터를 가지고 있다
class MyNumberViewModel:ViewModel() {

    companion object{
        private const val TAG:String = "로그"
    }


    //뮤터블 라이브 데이터 - 수정이 가능하다
    //라이브 데이터 -  값 변동 안됨

    //내부에서 설정하는 자료형은 뮤터블로
    //변경 가능하도록 생성
    private val _currentValue = MutableLiveData<Int>()

    //변경되지 않는 라이브데이터를 만들때는 _ 언더스코어 없이 생성
    //공개적으로 가져오는 변수는 private이 아닌 public으로 외부에서도 접근할 수 있도록 설정
    //하지만 값을 직접 라이브데이터에 접근하지 않고 뷰모델을 통해 가져올 수 있도록 설정
    val currentValue : LiveData<Int>
        get() = _currentValue


    init{
        Log.d(TAG,"MyNumberViewModel - 생성자 호출")
        _currentValue.value = 0
    }

    fun updateValue(actionType : ActionType, input: Int){
        when(actionType){
            ActionType.PLUS -> {
                _currentValue.value = _currentValue.value?.plus(input)
                Log.d(TAG,"MyNumberViewModel - updateValue_PLUS - input : $input , _currentValue :  ${_currentValue.value}")
            }

            ActionType.MINUS ->{
                _currentValue.value = _currentValue.value?.minus(input)
                Log.d(TAG,"MyNumberViewModel - updateValue_MINUS - input : $input , _currentValue :  ${_currentValue.value}")
            }
        }
    }
}