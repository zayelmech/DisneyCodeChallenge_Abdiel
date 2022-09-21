package com.imecatro.disneycodechallenge_abdiel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.imecatro.disneycodechallenge_abdiel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       supportActionBar?.setDisplayHomeAsUpEnabled(true);
       // supportActionBar?.isHideOnContentScrollEnabled =true
    }
}