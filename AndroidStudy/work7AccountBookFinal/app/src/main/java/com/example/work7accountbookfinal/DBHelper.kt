package com.example.work7accountbookfinal

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?,name:String?, factory:SQLiteDatabase.CursorFactory?,version: Int)
    :SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql:String = "CREATE TABLE IF NOT EXISTS ACCOUNT("+
                "SEQ INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EXPENSE INTEGER," +
                "TITLE TEXT," +
                "DATE TEXT," +
                "MONEY INTEGER," +
                "MEMO TEXT)"

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        var sql : String = " DROP TABLE IF EXISTS ACCOUNT "
        db?.execSQL(sql)
        onCreate(db)
    }
    fun insert(db:SQLiteDatabase?, account: Account){
        var sql:String = "INSERT INTO ACCOUNT('EXPENSE','TITLE','DATE','MONEY','MEMO')" +
                "VALUES('${account.expense}','${account.title}','${account.date}'" +
                ",'${account.money}','${account.memo}')"

        db?.execSQL(sql)
    }

    @SuppressLint("Range")
    fun search(db: SQLiteDatabase?, date:String) : MutableList<Account>{

        var list:MutableList<Account> = mutableListOf<Account>()
        val sql:String = "SELECT * FROM ACCOUNT WHERE DATE LIKE '${date}'"

        val account = db!!.rawQuery(sql,null)
        while(account.moveToNext()){
            val seq = account.getString(account.getColumnIndex("SEQ")).toInt()
            val expense = account.getString(account.getColumnIndex("EXPENSE")).toInt()
            val title = account.getString(account.getColumnIndex("TITLE"))
            val day = account.getString(account.getColumnIndex("DATE"))
            val money = account.getString(account.getColumnIndex("MONEY")).toInt()
            val memo = account.getString(account.getColumnIndex("MEMO"))

            list.add(Account(seq,expense,title,day,money,memo))
        }
        return list
    }
     @SuppressLint("Range")
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
     }

}