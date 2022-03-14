package com.example.pertemuan5_71190462

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val username = intent.getStringExtra("username")
        val tvGreetings = findViewById<TextView>(R.id.tvGreetings)
        tvGreetings.text = "Selamat datang $username"

    }
}
