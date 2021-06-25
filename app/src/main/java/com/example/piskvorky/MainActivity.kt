package com.example.piskvorky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //Testovací commit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        butt_start.setOnClickListener {clickStartListener()}
    }

    private val butt_start by lazy {
        findViewById<Button>(R.id.butt_start)
    }

    public fun clickStartListener(){
        val intent = Intent(this, HraActivity::class.java)
        startActivity(intent)
    }

    fun ahoj(){
    //smazal jsem ti metodu haha
    }

    //uz to vypada ze to funguje
    //zkouska
}