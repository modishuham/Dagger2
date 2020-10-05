package com.example.myapplication.network.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.myapplication.R

class NetworkActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.network_layout)
        replaceFragment()
    }

    private fun replaceFragment(){
       supportFragmentManager
           .beginTransaction()
           .replace(R.id.container_retro_room,RetroFragment())
           .commit()
    }
}
