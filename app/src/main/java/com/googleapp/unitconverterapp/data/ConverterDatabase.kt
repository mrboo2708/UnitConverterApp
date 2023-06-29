package com.googleapp.unitconverterapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//holds the database instance, is main access point to the database
@Database(entities = [ConversionResult::class],version = 1)
abstract class ConverterDatabase : RoomDatabase() {
    //provides an instance of converter dao to the other part of the application
    abstract val converterDAO : ConverterDAO

    companion object{
        @Volatile
        private var INSTANCE : ConverterDatabase? = null
        fun getInstance(context: Context): ConverterDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConverterDatabase::class.java,
                        "converter_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}