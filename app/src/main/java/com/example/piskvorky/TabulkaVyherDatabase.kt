package com.example.piskvorky

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TabulkaVyher::class], version = 1, exportSchema = false)
abstract class TabulkaVyherDatabase: RoomDatabase() {
    abstract val tabulkaVyherDao: DatabaseDao
    companion object{

        @Volatile
        private var INSTANCE : TabulkaVyherDatabase? = null
        fun getInstance(context: Context): TabulkaVyherDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TabulkaVyherDatabase::class.java,
                        "tabulka_vyher_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}