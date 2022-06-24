package com.example.a71190462_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class TambahMusikActivity : AppCompatActivity() {
    var firestore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_musik)
        val settings = FirebaseFirestoreSettings.Builder().setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED).build()
        firestore.firestoreSettings = settings

        val id = findViewById<EditText>(R.id.idTxv)
        val judul = findViewById<EditText>(R.id.judulTxv)
        val penyanyi = findViewById<EditText>(R.id.penyanyiTxv)
        val album = findViewById<EditText>(R.id.albumTxv)
        val genre = findViewById<EditText>(R.id.genreTxv)
        val tahunRilis = findViewById<EditText>(R.id.tahunTxv)
        val submit = findViewById<Button>(R.id.submitBtn)

        submit.setOnClickListener {
            val data = Musik(id.text.toString(), judul.text.toString(), penyanyi.text.toString(), album.text.toString(), genre.text.toString(), tahunRilis.text.toString())
            firestore.collection("musik").add(data).addOnSuccessListener {
                Toast.makeText(this, "Data berhasil disimpan!!", Toast.LENGTH_SHORT).show()
                id.setText("")
                judul.setText("")
                penyanyi.setText("")
                album.setText("")
                genre.setText("")
                tahunRilis.setText("")
            }.addOnFailureListener {
                Toast.makeText(this, "Data gagal disimpan!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}