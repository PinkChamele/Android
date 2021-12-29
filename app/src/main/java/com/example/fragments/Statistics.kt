package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.fragments.databinding.ActivityStatisticsBinding

class Statistics : AppCompatActivity() {
    lateinit var binding: ActivityStatisticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        val choices = realm.where(Choice::class.java).findAll().toMutableList().map { "firm: ${it.firm}, type: ${it.type}" }
        binding.lvHistory.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, choices)

        setContentView(binding.root)
    }
}