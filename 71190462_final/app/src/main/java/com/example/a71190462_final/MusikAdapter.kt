package com.example.a71190462_final

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


class MusikAdapter(var listMusik: ArrayList<Musik>, var context: Context): RecyclerView.Adapter<MusikAdapter.MusikHolder>(){
    class MusikHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(musik: Musik, context: Context, position: Int) {
            var firestore = FirebaseFirestore.getInstance()
            view.findViewById<TextView>(R.id.judulTxv).setText(musik.judulLagu)
            view.findViewById<TextView>(R.id.penyanyiTxv).setText(musik.namaPenyanyi)
            view.findViewById<TextView>(R.id.albumTxv).setText(musik.judulAlbum)
            view.findViewById<TextView>(R.id.genreTxv).setText(musik.genre)
            view.findViewById<TextView>(R.id.tahunTxv).setText(musik.tahunRilis)
            val editBtn = view.findViewById<Button>(R.id.editBtn)
            val deleteBtn = view.findViewById<Button>(R.id.deleteBtn)

            editBtn.setOnClickListener {
                val intent = Intent(context, EditMusikActivity::class.java)
                intent.putExtra("judulLagu", musik.judulLagu)
                intent.putExtra("namaPenyanyi", musik.namaPenyanyi)
                intent.putExtra("judulAlbum", musik.judulAlbum)
                intent.putExtra("genre", musik.genre)
                intent.putExtra("tahunRilis", musik.tahunRilis)
                context.startActivity(intent)
                (context as ListMusikActivity).finish()
            }

            deleteBtn.setOnClickListener {
                firestore.collection("musik")
                    .whereEqualTo("idLagu", musik.idLagu)
                    .get()
                    .addOnSuccessListener {
                        for(document in it) {
                            firestore.collection("musik").document(document.id)
                                .delete()
                        }
                        Toast.makeText(context,"Data Berhasil dihapus!!",Toast.LENGTH_SHORT).show()
                        context.startActivity(Intent(context, ListMusikActivity::class.java))
                    }.addOnFailureListener {
                        Toast.makeText(context, "Data gagal dihapus!!", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusikHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_musik, parent, false)
        return MusikHolder(v)
    }

    override fun onBindViewHolder(holder: MusikHolder, position: Int) {
        holder.bind(listMusik[position], context, position)
    }

    override fun getItemCount(): Int {
        return listMusik.size
    }
}