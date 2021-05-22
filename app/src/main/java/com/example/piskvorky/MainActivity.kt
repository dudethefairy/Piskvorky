package com.example.piskvorky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

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


    }

    fun ahoj(){
    //smazal jsem ti metodu haha
    }

    //uz to vypada ze to funguje
}