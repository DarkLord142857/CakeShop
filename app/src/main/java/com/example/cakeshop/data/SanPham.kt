package com.example.cakeshop.data

data class SanPham (
    val id:Int,
    val MaSP :String,
    val maLoai:String,
    val TenSP:String,
    val image:String,
    val moTa:String,
    val donGia: Double,
    val trangThai:Int,
    val soLuong:Int
)