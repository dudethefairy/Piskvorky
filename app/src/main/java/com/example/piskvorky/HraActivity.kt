package com.example.piskvorky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout

class HraActivity : AppCompatActivity() {

    val radky : Int = 10
    val sloupce : Int = 7
    val pole = Array(radky, {IntArray(sloupce)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hra)



        val layout = findViewById(R.id.gridLayout) as GridLayout

        // add Button to LinearLayout

        //vykreslení hrací plochy (tlačítek)
        for (i in 0..9) {
            for (j in 0..6) {

                val button1 = ImageButton(this)
                button1.setImageDrawable(getResources().getDrawable(R.drawable.prazdne))
                // setting layout_width and layout_height using layout parameter
                button1.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                button1.setOnClickListener{
                    pole[i][j] = 5
                    System.out.println(pole[i][j])
                    System.out.println("radek " + i)
                    System.out.println("sloupec " + j)
                }

                layout.addView(button1)

            }
        }

        for (row in pole) {
            println(row?.contentToString())
        }
    }


}