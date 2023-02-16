package com.example.loginandregistersqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Register : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var email: EditText
    private lateinit var signupbtn: Button
    private lateinit var signinbtn: Button
    private lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        uname = findViewById(R.id.editTextTextPersonName)
        pword = findViewById(R.id.editTextTextPersonName2)
        email = findViewById(R.id.editTextTextPersonName3)
        signupbtn = findViewById(R.id.button)
        signinbtn = findViewById(R.id.button2)
        db = DBHelper(this)

        signupbtn.setOnClickListener {
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val emailtext = email.text.toString()
            val savedata = db.insertdata(unametext, pwordtext)

            if (TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(emailtext)){
                Toast.makeText(this, "Add Username, Password & Email", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        signinbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}