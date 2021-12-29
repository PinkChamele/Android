package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragment(R.id.radio_buttons, RadioButtons())
        openFragment(R.id.message_fragment, MessageFragment())
        binding.historyButton.setOnClickListener {
            val intent = Intent(this, Statistics::class.java)
            startActivity(intent)
        }
    }

    private fun openFragment(holderId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(holderId, fragment)
            .commit()
    }
}