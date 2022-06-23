package com.example.sample36sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(context: Context?, name :String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
: SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
       var sql : String = " CREATE TABLE IF NOT EXISTS MYTABLE(" +
                          " SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          " TXT TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql : String = " DROP TABLE IF EXISTS MYTABLE "
        db?.execSQL(sql)
        onCreate(db)
    }

    fun insert(db:SQLiteDatabase,txt:String){
        var sql = "INSERT INTO MYTABLE('TXT')" +
                  "VALUES('${txt}') "
        db.execSQL(sql)

    }
    fun delete(db:SQLiteDatabase,seq:Int){
        var sql = "DELETE FROM MYTABLE" +
                  " WHERE SEQ =" + seq
        db.execSQL(sql)
    }
    fun select(db:SQLiteDatabase){
        val mytable = mutableListOf<String>()
        val sql ="SELECT * FROM MYTABLE"
        val cursor = db.rawQuery(sql,null)
        while(cursor.moveToNext()){
            val seq = cursor.getString(cursor.columnCount)
            val txt = cursor.getString(cursor.columnCount)
            mytable.add("$seq / $txt")
        }
        Toast.makeText(this,mytable.toString(),Toast.LENGTH_SHORT).SHOW()

    }
}