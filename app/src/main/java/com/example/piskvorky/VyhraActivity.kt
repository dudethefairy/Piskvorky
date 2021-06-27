package com.example.piskvorky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class VyhraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vyhra)
        val db = Room.databaseBuilder(applicationContext,
                TabulkaVyherDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        //výpis vítěze
        val vitez = intent.getStringExtra("vitez")
        val textViewVitez = findViewById<TextView>(R.id.textViewVitez)
        textViewVitez.setText(vitez)

        val pocetTahu = intent.getStringExtra("pocetTahu")
        //TODO výpis počtu tahu + uloženi do databáze


        //návrat zpět na úvodní plochu
        val textName = findViewById<TextView>(R.id.textview_jmeno)
        val buttonNepridej = findViewById<Button>(R.id.buttonCancel)
        val buttonPridej = findViewById<Button>(R.id.buttonOK)
        buttonNepridej.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonPridej.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            var name = textName.text.toString()
            if(name == ""|| name.length>50){
                name = "HracPiskvorek"
            }

            val hrac:TabulkaVyher = TabulkaVyher(jmeno = name, pocet_tahu = Integer.parseInt(pocetTahu), id = (Math.random()*1000).toLong(), datum = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString())
            db.tabulkaVyherDao.insert(hrac)
            startActivity(intent)
        }

    }
}