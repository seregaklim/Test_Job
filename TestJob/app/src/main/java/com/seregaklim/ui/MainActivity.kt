package com.seregaklim.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seregaklim.testjob.databinding.ActivityMainBinding


class AppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}