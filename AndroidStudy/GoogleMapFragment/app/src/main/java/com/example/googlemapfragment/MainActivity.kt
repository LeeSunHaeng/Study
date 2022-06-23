package com.example.googlemapfragment

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addrEdit = findViewById<EditText>(R.id.addText)
        var latText= findViewById<TextView>(R.id.latText)
        var lonText = findViewById<TextView>(R.id.lonText)
        var button = findViewById<Button>(R.id.button)
        val geocoder:Geocoder = Geocoder(this)

        button.setOnClickListener {

            var list:List<Address>? = null
            val str = addrEdit.text.toString()

            try{
                list = geocoder.getFromLocationName(str,10)
            }catch(e: IOException) {

            }
            if (list != null) {
                if (list!!.isEmpty()) {
                    Toast.makeText(this,"해당되는 주소가 없습니다",Toast.LENGTH_LONG).show()
                }else {
                    // textView.text = list!![0].toString()
                    latText.text = list!!.get(0).latitude.toString()
                    lonText.text = list!!.get(0).longitude.toString()
                    print("위도 : ${list!!.get(0).latitude.toString()} ")
                    println("경도 : ${list!!.get(0).longitude.toString()}")
                }

            }
            val fm = supportFragmentManager
            val fragmentTransaction = fm.beginTransaction()
            fragmentTransaction.add(R.id.content, MapsFragment(this,list!!.get(0).latitude,list!!.get(0).longitude))
            fragmentTransaction.commit()
        }


    }
}