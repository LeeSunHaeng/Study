package com.example.smaple26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        ratingBar.setOnRatingBarChangeListener{ratingBar,rating,fromUser
        -> textView.text="$rating"

        }
    }
}