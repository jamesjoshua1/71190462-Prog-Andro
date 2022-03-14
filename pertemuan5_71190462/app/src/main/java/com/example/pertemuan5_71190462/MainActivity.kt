package com.example.pertemuan5_71190462

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPass = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

       btnLogin.setOnClickListener {
           if(etPass.text.toString().equals("1234")){
               toast("Login Berhasil")
               val intent = Intent(this, LoginActivity::class.java)
               intent.putExtra("username", etUsername.text.toString())
               startActivity(intent)
           }else{
                toast("Login Gagal")
           }
       }
    }

    fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}