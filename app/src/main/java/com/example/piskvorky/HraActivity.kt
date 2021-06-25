package com.example.piskvorky

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class HraActivity : AppCompatActivity() {

    //private val radky : Int = 7
    //private val sloupce : Int = 7
    private val velikost : Int = 8
    //private val pole = Array(radky, {IntArray(sloupce)})
    private val pole = Array(velikost, {IntArray(velikost)})
    private var hrajiciHrac : Int = 1
    private var pocetTahu : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hra)


        val textViewInfo = findViewById<TextView>(R.id.textViewInfo)
        val layout = findViewById(R.id.gridLayout) as GridLayout
        val buttonKonec = findViewById<Button>(R.id.buttonKonec)

        //navrat zpet na uvodni plochu
        buttonKonec.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //vykreslení hrací plochy (tlačítek)
        for (i in 0..velikost-1) { //radky
            for (j in 0..velikost-1) { //sloupce
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
                    //kontrola zda již není pole obsazeno
                    if(pole[i][j] == 0) {
                        pocetTahu++

                        //hrac obsadi policko
                        pole[i][j] = hrajiciHrac

                        //v pristim tahu hraje druhy hrac
                        if (hrajiciHrac == 1) {
                            button1.setImageDrawable(getResources().getDrawable(R.drawable.krizek)) //1. hráč má křížek, 2. kolecko
                            hrajiciHrac = 2
                            textViewInfo.setText("hraje 2. hráč !")
                        }else {
                            button1.setImageDrawable(getResources().getDrawable(R.drawable.kolecko))
                            hrajiciHrac = 1
                            textViewInfo.setText("hraje 1. hráč !")
                        }

                        //kontrola zda nekdo jiz někdo nevyhral
                        val vysledek = zkontrolujVyhru()
                        if (vysledek != 0) {
                            textViewInfo.setText("konec hry, vyhrál " + vysledek + " hráč !")
                            val intent = Intent(this, VyhraActivity::class.java)
                            intent.putExtra("vitez", "vítězem se stává " + vysledek + ". hráč")
                            startActivity(intent)
                        }else{
                            if (vysledek == 3) textViewInfo.setText("konec hry, pole je zcela zaplneno !")
                        }
                    } else {
                        textViewInfo.setText("toto pole je již obsazeno !")
                    }

                }

                layout.addView(button1)

            }
        }

    }

    fun zkontrolujVyhru(): Int{
        // kontrola sloupcu
        for (i in 0 until velikost) {
            for (j in 0 until velikost - 3) {
                if (pole[i][j] === pole[i][j + 1] && pole[i][j] === pole[i][j + 2] && pole[i][j] === pole[i][j + 3] && pole[i][j] !== 0) {
                    return pole[i][j]
                }
            }
        }
        // kontrola radku
        for (j in 0 until velikost) {
            for (i in 0 until velikost - 3) {
                if (pole[i][j] === pole[i + 1][j] && pole[i][j] === pole[i + 2][j] && pole[i][j] === pole[i + 3][j] && pole[i][j] !== 0) {
                    return pole[i][j]
                }
            }
        }
        //kontrola uhlopricek
        for (i in 3 until velikost) {
            for (j in 0 until i - 2) {
                if (pole[i - j][j] === pole[i - j - 1][j + 1] && pole[i - j][j] === pole[i - j - 2][j + 2] && pole[i - j][j] === pole[i - j - 3][j + 3] && pole[i - j][j] !== 0) {
                    return pole[i - j][j]
                }
            }
        }

        for (i in 0 until velikost - 3) {
            for (j in 0 until velikost - 3 - i) {
                if (pole[i + j][velikost - 1 - j] === pole[i + j + 1][velikost - 2 - j] && pole[i + j][velikost - 1 - j] === pole[i + j + 2][velikost - 3 - j] && pole[i + j][velikost - 1 - j] === pole[i + j + 3][velikost - 4 - j] && pole[i + j][velikost - 1 - j] !== 0) {
                    return pole[i + j][velikost - 1 - j]
                }
            }
        }

        for (i in 0 until velikost - 3) {
            for (j in 0 until velikost - i - 3) {
                if (pole[i + j][j] === pole[i + j + 1][j + 1] && pole[i + j][j] === pole[i + j + 2][j + 2] && pole[i + j][j] === pole[i + j + 3][j + 3] && pole[i + j][j] !== 0) {
                    return pole[i + j][j]
                }
            }
        }

        for (j in 0 until velikost - 3) {
            for (i in 0 until velikost - j - 3) {
                if (pole[j][i + j] === pole[j + 1][i + j + 1] && pole[j][i + j] === pole[j + 2][i + j + 2] && pole[j][i + j] === pole[j + 3][i + j + 3] && pole[j][i + j] !== 0) {
                    return pole[j][i + j]
                }
            }
        }


        var konec = true // kontrola zaplnenosti pole

        for (i in 0 until velikost) {
            for (j in 0 until velikost) {
                if (pole[i][j] === 0) {
                    konec = false
                }
            }
        }
        if (konec) {
            return 3 // Konec - vsechny policka obsazeny
        }
        return 0
    }

}