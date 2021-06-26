package com.example.piskvorky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

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
        val pocitac = findViewById<RadioButton>(R.id.radio_pocitac)
        val intent = Intent(this, HraActivity::class.java)

        //předání zprávy zda hraje počítač
        if(pocitac.isSelected) {
            intent.putExtra("pocitac", true)
        }else {
            intent.putExtra("pocitac", false)
        }
        //spustení aktivity se samotnou hrou
        startActivity(intent)
    }

    fun ahoj(){
    //smazal jsem ti metodu haha
    }

    //uz to vypada ze to funguje
    //zkouska
}