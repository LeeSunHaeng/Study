package com.example.sample35singleturn

class Singleton {
    companion object{
        var chicken:String? = null
    }
}

/*
//java Singleton은 이렇게 김

    class Singleton{
    private static Sintgleton st = null;
    int number
    private Singleton(){

    }
    public Singleton getInstance(){
        if(st ==null){
        st = new Singleton();
        }
        return st;

        }
     }


//kotlin Singleton은 이렇게 짧음

object Singleton

 */