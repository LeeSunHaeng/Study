package com.example.favouritelist

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?,name:String?, factory:SQLiteDatabase.CursorFactory?,version: Int)
    :SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {

        var sql:String = "CREATE TABLE IF NOT EXISTS FAVOURITE("+
                "SEQ INTEGER PRIMARY KEY AUTOINCREMENT," +
                "IMAGEPATH TEXT," +
                "POSITIONLAT REAL," +
                "POSITIONLON REAL," +
                "CONTENT TEXT," +
                "DATE TEXT)"

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        var sql : String = " DROP TABLE IF EXISTS FAVOURITE "
        db?.execSQL(sql)
        onCreate(db)
    }
    fun insert(db:SQLiteDatabase?, favourite: Favourite){

        var sql:String = "INSERT INTO FAVOURITE('IMAGEPATH','POSITIONLAT','POSITIONLON','CONTENT','DATE')" +
                "VALUES('${favourite.imagePath}','${favourite.positionLat}','${favourite.positionLon}'" +
                ",'${favourite.content}','${favourite.date}')"


        db?.execSQL(sql)
    }

    @SuppressLint("Range")
    fun main(db: SQLiteDatabase?) : MutableList<Favourite>{

        var list:MutableList<Favourite> = mutableListOf<Favourite>()
        val sql:String = "SELECT * FROM FAVOURITE"

        val favourite = db!!.rawQuery(sql,null)
        while(favourite.moveToNext()){
            val seq = favourite.getString(favourite.getColumnIndex("SEQ")).toInt()
            val imagePath = favourite.getString(favourite.getColumnIndex("IMAGEPATH"))
            val positionLat = favourite.getString(favourite.getColumnIndex("POSITIONLAT")).toDouble()
            val positionLon = favourite.getString(favourite.getColumnIndex("POSITIONLON")).toDouble()
            val content = favourite.getString(favourite.getColumnIndex("CONTENT"))
            val date = favourite.getString(favourite.getColumnIndex("DATE"))

            list.add(Favourite(seq,imagePath,positionLat,positionLon,content,date))
        }
        return list
    }
    /* @SuppressLint("Range")
     fun periodSearch(db:SQLiteDatabase?, startDate:String, endDate:String):MutableList<Account> {
         var list:MutableList<Account> = mutableListOf<Account>()

         val sql:String ="SELECT * FROM ACCOUNT WHERE DATE BETWEEN '${startDate}' AND '${endDate}'"
         val account = db!!.rawQuery(sql,null)
         while(account.moveToNext()) {
             val seq = account.getString(account.getColumnIndex("SEQ")).toInt()
             val expense = account.getString(account.getColumnIndex("EXPENSE")).toInt()
             val title = account.getString(account.getColumnIndex("TITLE"))
             val day = account.getString(account.getColumnIndex("DATE"))
             val money = account.getString(account.getColumnIndex("MONEY")).toInt()
             val memo = account.getString(account.getColumnIndex("MEMO"))

             list.add(Account(seq, expense, title, day, money, memo))
         }
         return list
     }*/

}