package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InformationActivity : AppCompatActivity() {

    lateinit var textViewWelcome: TextView
    lateinit var textViewName: TextView
    lateinit var textViewPhone: TextView
    lateinit var textViewEmail: TextView

    lateinit var buttonSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        textViewWelcome = findViewById(R.id.textViewWelcome)
        textViewName = findViewById(R.id.textViewName)
        textViewPhone = findViewById(R.id.textViewPhone)
        textViewEmail = findViewById(R.id.textViewEmail)

        textViewWelcome.text = "Welcome ${Shared.account.name},"

        textViewName.text = Shared.account.name
        textViewPhone.text = Shared.account.phone.toString()
        textViewEmail.text = Shared.account.email

        buttonSignOut = findViewById(R.id.buttonSignOut)
        buttonSignOut.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }


    }
}