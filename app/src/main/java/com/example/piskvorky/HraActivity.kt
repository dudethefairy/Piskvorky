package com.example.piskvorky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout

class HraActivity : AppCompatActivity() {

    private val radky : Int = 7
    private val sloupce : Int = 7
    private val pole = Array(radky, {IntArray(sloupce)})
    private var hrajiciHrac : Int = 1
    private val textViewInfo by lazy { findViewById<Button>(R.id.textViewInfo) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hra)



        val layout = findViewById(R.id.gridLayout) as GridLayout

        //vykreslení hrací plochy (tlačítek)
        for (i in 0..radky-1) {
            for (j in 0..sloupce-1) {
                //vytvoreni tlacitka
                val button1 = ImageButton(this)
                button1.setImageDrawable(getResources().getDrawable(R.drawable.prazdne))
                // setting layout_width and layout_height using layout parameter
                button1.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                //tlacitko ovlada urcity index v 2D poli
                button1.setOnClickListener{
                    if(pole[i][j] != 0) {
                        //hrac obsadi policko
                        pole[i][j] = hrajiciHrac
                        //kontrola zda nekdo jiz nevyhral



                        //v pristim tahu hraje druhy hrac
                        if (hrajiciHrac == 1) {
                            hrajiciHrac = 2
                        }else {
                            hrajiciHrac = 1
                        }
                    } else {
                        textViewInfo.setText("toto pole je již obsazeno !")
                    }

                }

                layout.addView(button1)

            }
        }

        for (row in pole) {
            println(row?.contentToString())
        }
    }


}