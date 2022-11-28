package com.example.k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomePage : AppCompatActivity() {

    private lateinit var button5x5:Button
    private lateinit var button4x4:Button
    private lateinit var button3x3:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
        button5x5 = findViewById(R.id.button3)
        button4x4 = findViewById(R.id.button4)
        button3x3 = findViewById(R.id.button3x3)
        button5x5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("N", "5")
            startActivity(intent)
        }
        button4x4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("N","4")
            startActivity(intent)
        }
        button3x3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("N","3")
            startActivity(intent)
        }
    }
}