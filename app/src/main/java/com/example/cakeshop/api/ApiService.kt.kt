package com.example.cakeshop.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/dangnhap/tkql")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<LoginResponse>
}