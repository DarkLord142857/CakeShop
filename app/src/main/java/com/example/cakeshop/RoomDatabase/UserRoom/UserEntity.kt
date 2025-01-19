package com.example.cakeshop.RoomDatabase.UserRoom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_item")
data class UserEntity(
    @PrimaryKey() val MAND : String = "ND000",
    val tenND : String,
    val chucVu: String,
    val email: String,
    val sdt: String,
    val userName: String,
    val trangThai: Int,
)