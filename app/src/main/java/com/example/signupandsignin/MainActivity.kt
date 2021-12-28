package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val databaseHelper by lazy { DatabaseHelper(applicationContext) }

    lateinit var buttonSignIn: Button
    lateinit var buttonSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        Shared.main = this

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSignIn = findViewById(R.id.buttonSignIn)
        buttonSignUp = findViewById(R.id.buttonSignUp)

        buttonSignIn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        buttonSignUp.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

}