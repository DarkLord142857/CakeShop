package com.example.cakeshop.api

data class DoanhThu (
    val id_DT: Int,
    val maHD: Int,
    val tenKH: String,
    val dongia: Int,
    val thanhtien: Double,
    val ngay: String,
    val trangthai: Boolean,
)