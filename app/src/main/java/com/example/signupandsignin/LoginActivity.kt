package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {


    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)

        buttonSignIn = findViewById(R.id.buttonSignIn)
        buttonSignIn.setOnClickListener{
            val account = Shared.main.databaseHelper.getOneDataByEmail(editTextEmail.text.toString())
            if(account.pk == -1) {}
            else if(account.password == editTextPassword.text.toString()){
                Shared.account = account
                val intent = Intent(this, InformationActivity::class.java)
                startActivity(intent)
            }

        }

    }
}