package com.example.cakeshop.RoomDatabase

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cakeshop.RoomDatabase.CartRoom.CartEntity
import com.example.cakeshop.RoomDatabase.UserRoom.UserEntity


@Database(entities = [CartEntity::class,UserEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDao
    abstract fun CartDao(): CartDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @SuppressLint("SuspiciousIndentation")
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,

                    "cart_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                "app_database"
                INSTANCE = instance
                instance
            }
        }
    }

}