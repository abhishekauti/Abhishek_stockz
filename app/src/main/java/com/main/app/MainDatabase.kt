package com.main.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.main.app.dao.PaymentDao
import com.main.app.models.Payment


@Database(entities = arrayOf(Payment::class), version = 1, exportSchema = false)
abstract class MainDatabase: RoomDatabase() {

    abstract fun getPaymentDao(): PaymentDao

    companion object{
        private var instance: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase{
            if(instance == null){
                synchronized(this){
                    instance = Room.databaseBuilder(context.applicationContext,MainDatabase::class.java,"main-database")
                        .build()
                    return instance as MainDatabase
                }}
            return instance as MainDatabase

        }
    }
}