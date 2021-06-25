package com.example.piskvorky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout

class HraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hra)

        val button = Button(this)
        // setting layout_width and layout_height using layout parameter
        button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        val button1 = ImageButton(this)
        // setting layout_width and layout_height using layout parameter
        button1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        val layout = findViewById(R.id.gridLayout) as GridLayout
        // add Button to LinearLayout
        layout.addView(button)
        layout.addView(button1)
    }
}