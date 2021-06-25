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

        val vitez = intent.getStringExtra("vitez")
        val textViewVitez = findViewById<TextView>(R.id.textViewVitez)
        textViewVitez.setText(vitez)

        val buttonKonec = findViewById<Button>(R.id.buttonOK)
        buttonKonec.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}