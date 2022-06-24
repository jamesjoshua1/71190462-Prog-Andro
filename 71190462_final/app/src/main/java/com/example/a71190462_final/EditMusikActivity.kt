package com.example.a71190462_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class EditMusikActivity : AppCompatActivity() {
    var firestore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_musik)

        val id = findViewById<EditText>(R.id.idTxv)
        val judul = findViewById<EditText>(R.id.judulTxv)
        val penyanyi = findViewById<EditText>(R.id.penyanyiTxv)
        val album = findViewById<EditText>(R.id.albumTxv)
        val genre = findViewById<EditText>(R.id.genreTxv)
        val tahunRilis = findViewById<EditText>(R.id.tahunTxv)
        val submit = findViewById<Button>(R.id.submitBtn)

        id.setText("${getIntent().getStringExtra("idLagu")}")
        judul.setText("${getIntent().getStringExtra("judulLagu")}")
        penyanyi.setText("${getIntent().getStringExtra("penyanyi")}")
        album.setText("${getIntent().getStringExtra("album")}")
        genre.setText("${getIntent().getStringExtra("genre")}")
        tahunRilis.setText("${getIntent().getStringExtra("tahun")}")
//
        submit.setOnClickListener {
            val data = Musik(judul.text.toString(), penyanyi.text.toString(), album.text.toString(), genre.text.toString(), id.text.toString(), tahunRilis.text.toString())
            firestore.collection("musik")
                .whereEqualTo("id", getIntent().getStringExtra("id"))
                .get()
                .addOnSuccessListener {
                    for(document in it) {
                        firestore.collection("musik").document(document.id)
                            .update("id", id.text.toString(), "judulLagu", judul.text.toString(), "album", album.text.toString(), "penyanyi", penyanyi.text.toString(), "genre", genre.text.toString(), "tahun", tahunRilis.text.toString())

                    }
                    Toast.makeText(this@EditMusikActivity, "Data berhasil diudpate!!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, ListMusikActivity::class.java))
                }.addOnFailureListener {
                    Toast.makeText(this@EditMusikActivity, "Data gagal diudpate!!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}