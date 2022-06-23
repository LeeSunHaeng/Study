package com.example.work3bballteacher

import kotlin.random.Random

class BaseBall {

    var randNum:IntArray = IntArray(3)
    var clear:Boolean = false

    constructor(){

    }

    fun random(){
        /*randNum[0] = (Math.random()*10).toInt()+1
        randNum[1] = (Math.random()*10).toInt()+1
        randNum[2] = (Math.random()*10).toInt()+1*/
        var switch = BooleanArray(10)
        for(i in switch.indices){
            switch[i]=false
        }

        var w = 0

        while(w < 3) {
            var r = (Math.random() * 10).toInt()
            if (switch[r] == false) {
                switch[r] = true
                randNum[w] = r + 1
                w++
            }
        }

        for(i in randNum.indices){
            println("randNum[$i]=${randNum[i]}")
        }

        // 판정
        fun finding(userNum:Array<Int>) : Result {
            var strike:Int = 0
            var ball: Int = 0

            //ball
            for(i in userNum.indices){
                for(j in userNum.indices){
                    if(userNum[i]==randNum[j] && i != j){
                        ball++
                    }
                }
            }
            //strike
            for(i in userNum.indices){
                if(userNum[i] == randNum[i]){
                    strike++
                }
            }
            return Result(strike,ball)
        }

        //결과
        fun resultString() : String{
            if(clear == true){
            return "축하합니다 게임 클리어"

            }
            else{
            return "아쉽습니다 다시 도전하세요"
            }
        }



    }
    class Result(val strke:Int, val ball:Int)
}