package com.example.login

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EasyActivity : AppCompatActivity() {

    object userNameConstants {
        const val userName = "USER"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_easy)

        val btonEasy = findViewById(R.id.btonEasy) as Button

        btonEasy.setOnClickListener()
        {
            val menuSound = MediaPlayer.create(this, R.raw.menu_sound)
            menuSound.start()
            // crear nueva activity

            menuSound.setOnCompletionListener {
                menuSound.stop()
            }
        }
    }
}