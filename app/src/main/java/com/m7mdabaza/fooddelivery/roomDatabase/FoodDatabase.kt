package com.m7mdabaza.fooddelivery.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1, exportSchema = false)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getDatabaseInstance(context: Context): FoodDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "food_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}