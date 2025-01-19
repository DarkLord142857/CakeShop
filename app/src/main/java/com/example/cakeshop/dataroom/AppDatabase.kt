package com.example.cakeshop.dataroom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cakeshop.dataroom.CartRoom.ItemEntity
import com.example.cakeshop.dataroom.UserRoom.UserEntity


@Database(entities = [ItemEntity::class,UserEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}