package com.example.cakeshop.dataroom.CartRoom

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cart_items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val maSP:String,
    val tenSP:String,
    val donGia:Double,
    val soLuong: Int,
    val soLuongSP: Int,
    val imageUrl:String
)
