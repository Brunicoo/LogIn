package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.transition.Explode
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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
                val shake: Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
                userNameEditText.startAnimation(shake);
                Toast.makeText(this, "¡You must enter your name!", Toast.LENGTH_LONG).show()
            }
            else {
                val userName = userNameEditText.text
                if (difficulty != null) {
                    if (difficulty == false) {
                        val loginSound = MediaPlayer.create(this, R.raw.login_sound)
                        loginSound.start()
                        val intent = Intent(this, EasyActivity :: class.java)
                        intent.putExtra(EasyActivity.userNameConstants.userName, userName)
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in_and_glow, R.anim.fade_out_and_glow)

                        loginSound.setOnCompletionListener {
                            loginSound.stop()
                        }

                    } else if (difficulty == true) {
                        val loginSound = MediaPlayer.create(this, R.raw.login_sound)
                        loginSound.start()

                        val intent = Intent(this, HardActivity :: class.java)
                        intent.putExtra(HardActivity.userNameConstants.userName, userName)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                        loginSound.setOnCompletionListener {
                            loginSound.stop()
                        }

                    }
                } else {
                    val shake: Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
                    btonEasy.startAnimation(shake)
                    btonHard.startAnimation(shake)
                    Toast.makeText(this, "¡You must select a difficulty!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}