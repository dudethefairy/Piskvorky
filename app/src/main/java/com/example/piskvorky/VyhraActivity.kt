package com.example.piskvorky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class VyhraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vyhra)

        //výpis vítěze
        val vitez = intent.getStringExtra("vitez")
        val textViewVitez = findViewById<TextView>(R.id.textViewVitez)
        textViewVitez.setText(vitez)

        val pocetTahu = intent.getStringExtra("pocetTahu")
        //TODO výpis počtu tahu + uloženi do databáze

        //návrat zpět na úvodní plochu
        val buttonKonec = findViewById<Button>(R.id.buttonOK)
        buttonKonec.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}