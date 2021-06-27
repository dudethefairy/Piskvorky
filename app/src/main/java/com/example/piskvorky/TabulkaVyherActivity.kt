package com.example.piskvorky

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


class TabulkaVyherActivity : AppCompatActivity() {

    private val butt_Vymaz by lazy {
        findViewById<Button>(R.id.butt_Vymaz)
    }
    private val butt_Back by lazy {
        findViewById<Button>(R.id.butt_Back)
    }
    private val db = Room.databaseBuilder(
        applicationContext,
        TabulkaVyherDatabase::class.java, "database-name"
    ).allowMainThreadQueries().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabulka)

        butt_Vymaz.setOnClickListener { clickVymazListener() }
        butt_Back.setOnClickListener { clickBackListener() }
    }

    public fun clickVymazListener(){
        db.tabulkaVyherDao.clear()
    }
    public fun clickBackListener(){

        val intent = Intent(this, MainActivity::class.java)

        //vrácení se do menu
        startActivity(intent)
    }
}