package com.example.membersprrestful

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idEditText = findViewById<EditText>(R.id.id_editText)
        var pwdEditText = findViewById<EditText>(R.id.pwd_editText)
        val loginBtn = findViewById<Button>(R.id.login_btn)

        loginBtn.setOnClickListener {

            val dto = MemberDto(idEditText.text.toString(),pwdEditText.text.toString(),"","",3)
            val loginCheck = MemberDao.getInstance().login(dto)
            println("~~~~~~~~login : $loginCheck")
            if (loginCheck != null) {

                    val intent = Intent(this,BbsActivity::class.java)
                    startActivity(intent)

                }else{
                    idEditText.text=null
                    pwdEditText.text=null
                }



        }

    }
}
