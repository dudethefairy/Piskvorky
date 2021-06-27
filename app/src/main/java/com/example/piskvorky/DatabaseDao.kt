package com.example.piskvorky

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Insert
    fun insert(tabulkaVyher : TabulkaVyher)
    @Query("DELETE FROM tabulka_vyher")
    fun clear()
    @Query("SELECT * FROM tabulka_vyher WHERE pocet_tahu = :pt")
    fun getPocetTahu(pt : Int):List<TabulkaVyher>
    @Query("SELECT * FROM tabulka_vyher")
    fun getVsechno():List<TabulkaVyher>
    @Query("DELETE FROM tabulka_vyher WHERE pocet_tahu = :pt AND jmeno LIKE :jm")
    fun vymazVyhru(jm: String,pt: Int)

}