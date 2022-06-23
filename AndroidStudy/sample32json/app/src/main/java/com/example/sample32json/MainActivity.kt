package com.example.sample32json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonString = assets.open("data.json").reader().readText()
        Log.d("jsonStr", jsonString)

        //  Json으로 파싱
        val jsonArray = JSONArray(jsonString)
        Log.d("jsonStr", jsonArray.toString())

        val textView = findViewById<TextView>(R.id.textView)

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)

            textView.append("\n--------------------------\n")

            val id = jsonObject.getString("id")
            val language = jsonObject.getString("language")
            textView.append(
                """
                    $id
                """.trimIndent()
            )
            textView.append(
                """
                    $language
                """.trimIndent()
            )


        }
    }
}