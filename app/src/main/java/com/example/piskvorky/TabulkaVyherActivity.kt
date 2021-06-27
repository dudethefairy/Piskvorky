package com.example.piskvorky

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


class TabulkaVyherActivity : AppCompatActivity() {

    private val butt_Vymaz by lazy {
        findViewById<Button>(R.id.butt_Vymaz)
    }
    private val butt_Back by lazy {
        findViewById<Button>(R.id.butt_Back)
    }
    private val textview_tabulka by lazy {
        findViewById<TextView>(R.id.textview_tabulka)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabulka)
        val db = Room.databaseBuilder(applicationContext,
                TabulkaVyherDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
        butt_Vymaz.setOnClickListener {
            db.tabulkaVyherDao.clear()
            textview_tabulka.setText(" ")
        }
        butt_Back.setOnClickListener { clickBackListener() }
        textview_tabulka.setText(" ")
        db.tabulkaVyherDao.getVsechno().forEach{textview_tabulka.setText(textview_tabulka.text.toString() + it + "\n ")}
    }

    public fun clickBackListener(){

        val intent = Intent(this, MainActivity::class.java)

        //vrácení se do menu
        startActivity(intent)
    }
}