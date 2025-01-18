package com.example.cakeshop.api

import com.example.cakeshop.data.TaiKhoanQL
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("tkql")
    suspend fun QLDangNhap(): List<TaiKhoanQL>

    @GET("tkql")
    suspend fun getQuanLiById(
        @Path("idQL") idQL: String
    ): TaiKhoanQL

    @POST("/dangnhap/tkql")
    suspend fun kiemTraDangNhap(
        @Body loginResponse: LoginResponse
    ): Response<LoginResponse>
}

