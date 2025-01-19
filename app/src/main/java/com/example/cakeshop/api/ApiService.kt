package com.example.cakeshop.api

import com.example.cakeshop.data.CapNhapDonHangReponse
import com.example.cakeshop.data.CapNhapDonHangRequest
import com.example.cakeshop.data.CapNhapNguoiDungRequest
import com.example.cakeshop.data.CapnhapNguoiDungReponse
import com.example.cakeshop.data.ChiTietHoaDon
import com.example.cakeshop.data.HoaDon
import com.example.cakeshop.data.HoaDonChiTietReponse
import com.example.cakeshop.data.HoaDonChiTietRequest
import com.example.cakeshop.data.HoaDonReponse
import com.example.cakeshop.data.HoaDonRequest
import com.example.cakeshop.data.LoaiSP
import com.example.cakeshop.data.LoginReponse
import com.example.cakeshop.data.LoginRequest
import com.example.cakeshop.data.RegisterRequest
import com.example.cakeshop.data.RegisterResponse
import com.example.cakeshop.data.SanPham
import com.example.cakeshop.data.UpdatePasswordRequest
import com.example.cakeshop.data.UpdatePasswordResponse
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("sanpham/danhsachsanpham.php")
    suspend fun getSanPham():List<SanPham>

    @GET("loaisp/danhsachloaisp.php")
    suspend fun getLoaiSP():List<LoaiSP>

    @POST("nguoidung/updatepassword.php")
    suspend fun capnhatmatkhau(@Body request: UpdatePasswordRequest): UpdatePasswordResponse

    @Headers("Content-Type: application/json")
    @POST("nguoidung/dangky.php")
    suspend fun dangky(@Body request: RegisterRequest): RegisterResponse

    @POST("nguoidung/dangnhap.php")
    suspend fun dangnhap(@Body request: LoginRequest): LoginReponse

    @GET("sanpham/laysanphamtheomasp.php")
    suspend fun getChiTietSanPham(@Query("id") productId: String): SanPham

    @GET("hoadon/danhsachhoadon.php")
    suspend fun  getHoaDon():List<HoaDon>

    @Headers("Content-Type: application/json")
    @POST("hoadon/addhoadon.php")
    suspend fun themhoadon(@Body request: HoaDonRequest): HoaDonReponse

    @Headers("Content-Type: application/json")
    @POST("chitiethoadon/addcthd.php")
    suspend fun themchitiethoadon(@Body request: HoaDonChiTietRequest): HoaDonChiTietReponse

    @GET("chitiethoadon/dscthd.php")
    suspend fun getChiTietHoaDon(@Query("MaHD") maHD: String): List<ChiTietHoaDon>

    @Headers("Content-Type: application/json")
    @POST("hoadon/updatetrangthai.php")
    suspend fun capnhapdonhang(@Body request: CapNhapDonHangRequest): CapNhapDonHangReponse

    @POST("nguoidung/capnhapnguoidung.php")
    suspend fun capnhapnguoidung(@Body request: CapNhapNguoiDungRequest): CapnhapNguoiDungReponse
}

object RetrofitInstance{
    val api:ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.194/API_php/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
            .create(ApiService::class.java)
    }
}