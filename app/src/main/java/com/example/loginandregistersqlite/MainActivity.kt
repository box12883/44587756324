package com.example.loginandregistersqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnsignup: Button
    private lateinit var loginbtn: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsignup = findViewById(R.id.button2)
        loginbtn = findViewById(R.id.button)
        edituser = findViewById(R.id.editTextTextPersonName)
        editpword = findViewById(R.id.editTextTextPersonName2)
        dbh = DBHelper(this)

        btnsignup.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        loginbtn.setOnClickListener{
            val useredtx = edituser.text.toString()
            val passedtx = editpword.text.toString()

            if (TextUtils.isEmpty(useredtx) || TextUtils.isEmpty(passedtx)){
                Toast.makeText(this, "Add Username & Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(useredtx, passedtx)
                if(checkuser == true){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Success::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Wrong Username & Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}