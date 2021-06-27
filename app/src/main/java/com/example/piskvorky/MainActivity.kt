package com.example.piskvorky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    private val pocitac by lazy {findViewById<RadioButton>(R.id.radio_pocitac)}

    //Testovací commit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        butt_start.setOnClickListener {clickStartListener()}
        butt_tabVyher.setOnClickListener {clickTabVyherListener()}
    }

    private val butt_start by lazy {
        findViewById<Button>(R.id.butt_start)
    }
    private val butt_tabVyher by lazy {
        findViewById<Button>(R.id.butt_tabVyher)
    }

    public fun clickStartListener(){

        val intent = Intent(this, HraActivity::class.java)

        //předání zprávy zda hraje počítač
        if(pocitac.isChecked) {
            intent.putExtra("pocitac", "true")
        }else{
            intent.putExtra("pocitac", "false")
        }
        //spustení aktivity se samotnou hrou
        startActivity(intent)
    }

    public fun clickTabVyherListener(){

        val intent = Intent(this, HraActivity::class.java)

        //předání zprávy zda hraje počítač
        if(pocitac.isChecked) {
            intent.putExtra("pocitac", "true")
        }else{
            intent.putExtra("pocitac", "false")
        }
        //spustení aktivity se samotnou hrou
        startActivity(intent)
    }
}