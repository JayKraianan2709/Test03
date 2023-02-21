package com.example.example2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {

    lateinit var buttonCal:Button
    lateinit var buttonQuzi:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonCal = findViewById<Button>(R.id.buttonCalculator)
        buttonQuzi = findViewById<Button>(R.id.buttonQuiz)

        buttonCal!!.setOnClickListener{
            val intern = Intent(this,Claculator::class.java)
            startActivity(intern)
        }
        buttonQuzi!!.setOnClickListener{
            val intern = Intent(this,Quiz::class.java)
            startActivity(intern)
        }

        }
    }
