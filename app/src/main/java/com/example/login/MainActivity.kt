package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btonEasy = findViewById(R.id.btonEasy) as Button
        val btonHard = findViewById(R.id.btonHard) as Button
        val btonStart = findViewById(R.id.btonStart) as Button
        val userNameEditText = findViewById(R.id.userName) as EditText
        var difficulty : Boolean? = null

        btonEasy.setOnClickListener()
        {
            difficulty = false
            btonEasy.setBackgroundResource(R.drawable.button_selected_easy)
            btonHard.setBackgroundResource(R.drawable.rectangle_borders2)
        }

        btonHard.setOnClickListener()
        {
            difficulty = true
            btonHard.setBackgroundResource(R.drawable.button_selected_hard)
            btonEasy.setBackgroundResource(R.drawable.rectangle_borders)
        }

        btonStart.setOnClickListener()
        {
            if (userNameEditText.text.isEmpty())
            {
                Toast.makeText(this, "¡You must enter your name!", Toast.LENGTH_LONG).show()
            }
            else {
                if (difficulty != null) {
                    if (difficulty == false) {
                        val intent = Intent(this, EasyActivity :: class.java)
                        startActivity(intent)

                    } else if (difficulty == true) {
                        //abrir activity del hard
                    }
                } else {
                    Toast.makeText(this, "¡You must select a difficulty!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}