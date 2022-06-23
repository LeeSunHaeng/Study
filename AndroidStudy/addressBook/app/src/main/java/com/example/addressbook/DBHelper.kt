package com.example.favouritelist

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.addressbook.AddressDto

class DBHelper(context: Context?,name:String?, factory:SQLiteDatabase.CursorFactory?,version: Int)
    :SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(db: SQLiteDatabase?) {

        var sql:String = "CREATE TABLE IF NOT EXISTS ADDRESSBOOK("+
                "NAME TEXT," +
                "AGE NUMBER," +
                "RELATIVE TEXT," +
                "JOB TEXT," +
                "ADDRESS TEXT," +
                "PHONENUMBER TEXT" +
                ")"

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        var sql : String = " DROP TABLE IF EXISTS ADDRESS "
        db?.execSQL(sql)
        onCreate(db)
    }
    fun insert(db:SQLiteDatabase?, address: AddressDto){

        var sql:String = "INSERT INTO ADDRESSBOOK('NAME','AGE','RELATIVE','JOB','ADDRESS','PHONENUMBER')" +
                "VALUES('${address.name}','${address.age}','${address.relation}'" +
                ",'${address.job}','${address.address}','${address.phoneNumber}')"


        db?.execSQL(sql)
    }

    @SuppressLint("Range")
    fun main(db: SQLiteDatabase?) : MutableList<AddressDto>{

        var list:MutableList<AddressDto> = mutableListOf<AddressDto>()
        val sql:String = "SELECT * FROM ADDRESSBOOK"

        val address = db!!.rawQuery(sql,null)
        while(address.moveToNext()){

            val phoneNum = address.getString(address.getColumnIndex("PHONENUMBER"))
            val name = address.getString(address.getColumnIndex("NAME"))
            val age = address.getString(address.getColumnIndex("AGE")).toInt()
            val relative = address.getString(address.getColumnIndex("RELATIVE"))
            val job = address.getString(address.getColumnIndex("JOB"))
            val address = address.getString(address.getColumnIndex("ADDRESS"))


            list.add(AddressDto(name,age,relative,job,address,phoneNum))
        }
        return list
    }

    @SuppressLint("Range")
    fun search(db:SQLiteDatabase?, name:String) : MutableList<AddressDto>{

        var list:MutableList<AddressDto> = mutableListOf<AddressDto>()
        val sql:String = "SELECT * FROM ADDRESSBOOK WHERE NAME ='${name}'"


        val address = db!!.rawQuery(sql,null)

        while(address.moveToNext()){

            val phoneNum = address.getString(address.getColumnIndex("PHONENUMBER"))
            val name = address.getString(address.getColumnIndex("NAME"))
            val age = address.getString(address.getColumnIndex("AGE")).toInt()
            val relative = address.getString(address.getColumnIndex("RELATIVE"))
            val job = address.getString(address.getColumnIndex("JOB"))
            val address = address.getString(address.getColumnIndex("ADDRESS"))


            list.add(AddressDto(name,age,relative,job,address,phoneNum))
        }
        return list
    }

    fun delete(db:SQLiteDatabase,name:String){

        var list:MutableList<AddressDto> = mutableListOf<AddressDto>()
        val sql:String = "DELETE  FROM ADDRESSBOOK WHERE NAME ='${name}'"


        db?.execSQL(sql)


    }


}