package id.ac.ukdw.pertemuan7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    val listContact = arrayListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listContact.add(Contact("Jamppi", "081236455768", R.mipmap.jamppi_round))
        listContact.add(Contact("ScreaM", "081233456778", R.mipmap.scream_round))
        listContact.add(Contact("Nivera", "081384569430", R.mipmap.nivera_round))
        listContact.add(Contact("L1NK","081818181818",R.mipmap.l1nk_round))
        listContact.add(Contact("soulcas","08190909090",R.mipmap.soulcas_round))

        val rcyContact = findViewById<RecyclerView>(R.id.rcyContact)
        rcyContact.layoutManager = LinearLayoutManager(this)
        val adapter = ContactAdapter(listContact, this)
        rcyContact.adapter = adapter
    }
}