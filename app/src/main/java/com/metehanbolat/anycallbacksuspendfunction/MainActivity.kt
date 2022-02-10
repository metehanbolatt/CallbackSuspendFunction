package com.metehanbolat.anycallbacksuspendfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.metehanbolat.anycallbacksuspendfunction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.countries.observe(this) {
            println(it)
        }

    }
}