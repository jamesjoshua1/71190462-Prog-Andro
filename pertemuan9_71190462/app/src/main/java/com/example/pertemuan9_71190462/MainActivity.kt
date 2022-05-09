package com.example.pertemuan9_71190462

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    var sp: SharedPreferences? = null
    var spEdit: SharedPreferences.Editor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sp = getSharedPreferences("mySP", Context.MODE_PRIVATE)
        spEdit = sp?.edit()
        if (sp?.getBoolean("isLogin", false) == true) {
            setContentView(R.layout.activity_main)
            val spBahasa = findViewById<Spinner>(R.id.spinBahasa)
            val adapter = ArrayAdapter.createFromResource(this, R.array.list_bahasa, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            spBahasa.adapter = adapter
            spBahasa.setSelection(sp!!.getInt("bahasa", 1))
            spBahasa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view:View, position: Int, id: Long) {
                    spEdit?.putInt("bahasa", position)
                    spEdit?.commit()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

            val etUkuran = findViewById<EditText>(R.id.inputFont)
            etUkuran.setText(sp!!.getString("ukuran", "10").toString())
            etUkuran.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    spEdit?.putString("ukuran", s.toString())
                    spEdit?.commit()
                }
            })
        } else {
            setContentView(R.layout.activity_login)
            val username = findViewById<EditText>(R.id.inputUsername)
            val password = findViewById<EditText>(R.id.inputPass)
            val buttonLogin = findViewById<Button>(R.id.btnLogin)
            val notifikasi = findViewById<TextView>(R.id.salahPass)
            buttonLogin.setOnClickListener {
                if (username.text.toString() == "admin" && password.text.toString() == "1234") {
                    spEdit?.putBoolean("isLogin", true)
                    spEdit?.commit()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }
                else {
                    notifikasi.text = "Username atau Password salah."
                }
            }
        }
    }
}
