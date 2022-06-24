package com.example.a71190462_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ListMusikActivity : AppCompatActivity() {
    val listMusik = arrayListOf<Musik>()
    val firestore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listmusik)
        refreshData()
    }

    fun createView() {
        val rcyContact = findViewById<RecyclerView>(R.id.rcyMusik)
        rcyContact.layoutManager = LinearLayoutManager(this)
        val adapter = MusikAdapter(listMusik, this)
        rcyContact.adapter = adapter
    }

    fun refreshData() {
        firestore.collection("musik").get()
            .addOnSuccessListener {documents ->
                for(document in documents) {
                    listMusik.add(Musik("${document.data["judulLagu"]}", "${document.data["namaPenyanyi"]}", "${document.data["judulAlbum"]}", "${document.data["genre"]}", "${document.data["tahunRilis"]}", "${document.data["idLagu"]}"))
                }
                createView()
            }.addOnFailureListener {
                Toast.makeText(this, "Data gagal direload", Toast.LENGTH_LONG)
            }

    }
}