package com.example.work5regi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Dao ==
//Singleton
class DBHelper(context: Context, filename:String) :SQLiteOpenHelper(context,filename,null,1) {

    companion object{
        private var dbhelper:DBHelper? =null
        fun getInstance(context:Context,filename:String) : DBHelper{
            if(dbhelper == null){
                dbhelper == DBHelper(context,filename)
            }
            return dbhelper!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var sql:String = "CREATE TABLE IF NOT EXISTS MEMBER(" +
                "  SEQ INTEGER PRIMARY KEY AUTOINCREMENT," +
                "  NAME STRING NOT NULL," +
                "  AGE INTEGER NOT NULL," +
                "  ADDRESS STRING NOT NULL) "
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}
//writableDatebse

fun insert(vo:Member){
    var sql = "INSERT INTO MEMBER(NAME, AGE, ADDRESS)" +
            "VALUES('${vo.name}','${vo.age}','${vo.address}')"
    var db = this.w
}