package com.example.cakeshop.data


data class TaiKhoanQL(
    val idQL: String,
    var username: String,
    var password: String,
    var tenQL: String,
    var email: String,
    var phone: String,
)

data class quanlyResponse(
    val protocol: String,
    val code:String,
    var url:String
)
