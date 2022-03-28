package id.ac.ukdw.pertemuan7

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class ContactDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = intent.getStringExtra("nama")
        val name = findViewById<TextView>(R.id.txtNama)
        name.text = nama
        val number = intent.getStringExtra("nomor")
        val num = findViewById<TextView>(R.id.txtNomor)
        num.text = number
        val address = intent.getStringExtra("alamat")
        val alamat = findViewById<TextView>(R.id.txtAlamat)
        alamat.text = address
        val surel = intent.getStringExtra("email")
        val email = findViewById<TextView>(R.id.txtEmail)
        email.text = surel

        }
    }




