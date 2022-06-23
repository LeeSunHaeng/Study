package com.example.work7accountbookcopy

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

    fun search(db: SQLiteDatabase?,date:String) : MutableList<Account>{

        var list:MutableList<Account> = mutableListOf<Account>()
        val sql:String = "SELECT *" +
                         "FROM ACCOUNT" +
                         "WHERE DATE='${date}"

        val account = db!!.rawQuery(sql,null)
        while(account.moveToNext()){
            val seq = account.getColumnIndex("SEQ")
            val expense = account.getColumnIndex("EXPENSE")
            val title = account.getColumnIndex("TITLE").toString()
            val day = account.getColumnIndex("DATE").toString()
            val money = account.getColumnIndex("MONEY")
            val memo = account.getColumnIndex("MEMO").toString()

            list.add(Account(seq,expense,title,day,money,memo))
        }
        return list
    }

}