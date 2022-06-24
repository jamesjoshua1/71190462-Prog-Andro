package com.example.a71190462_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var logoutButton = findViewById<Button>(R.id.LogoutButton)
        var tambahMusikButton = findViewById<Button>(R.id.TambahMusiktxv)
        var lihatMusikButton = findViewById<Button>(R.id.LihatMusiktxv)
        var emailTxv  = findViewById<TextView>(R.id.emailtxv)
        var cariMusikButton = findViewById<Button>(R.id.CariMusiktxv)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        val firebaseUser = firebaseAuth.currentUser
        val email = firebaseUser?.email
        emailTxv.text = email

        //handle click, logout user
        logoutButton.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
        lihatMusikButton.setOnClickListener {
            val toListMusik = Intent(this, ListMusikActivity::class.java)
            startActivity(toListMusik)
        }
        tambahMusikButton.setOnClickListener {
            val toTambahMusik = Intent(this, TambahMusikActivity::class.java)
            startActivity(toTambahMusik)
        }
        cariMusikButton.setOnClickListener {
            val toCariMusik = Intent(this, SearchActivity::class.java)
            startActivity(toCariMusik)
        }


    }

    private fun checkUser() {
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            //user not logged in
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}