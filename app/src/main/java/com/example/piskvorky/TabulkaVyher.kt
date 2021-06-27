package com.example.piskvorky

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Entity(tableName = "tabulka_vyher")
data class TabulkaVyher(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "jmeno")
    val jmeno: String,
    @ColumnInfo(name = "pocet_tahu")
    val pocet_tahu: Int,
    @ColumnInfo(name = "datum")
    val datum: String


) {
    override fun toString(): String {
        return "$jmeno,   $pocet_tahu,   $datum"
    }
}