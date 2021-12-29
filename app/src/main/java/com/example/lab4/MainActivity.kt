package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_video).setOnClickListener {
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_audio).setOnClickListener {
            val intent = Intent(this, Audio::class.java)
            startActivity(intent)
        }
    }
}
