package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    lateinit var editTextName: TextView
    lateinit var editTextPhone: TextView
    lateinit var editTextEmail: TextView
    lateinit var editTextPassword: TextView
    lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextName = findViewById(R.id.editTextName)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)

        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener{

            val account = Account(
                0,
                editTextName.text.toString(),
                editTextPhone.text.toString(),
                editTextEmail.text.toString(),
                editTextPassword.text.toString()
            )
            Shared.main.databaseHelper.saveData(account)
            Shared.account = account

            val intent = Intent(this, InformationActivity::class.java)
            startActivity(intent)
        }
    }
}