package com.example.cakeshop.data

import com.example.cakeshop.RoomDatabase.UserRoom.UserEntity
import com.google.gson.annotations.SerializedName

// Dùng cho đăng ký
data class RegisterRequest(
    @SerializedName("TENND") val tenND: String,
    @SerializedName("SDT") val sdt: String,
    @SerializedName("USERNAME") val userName: String,
    @SerializedName("PASSWORD") val passWord: String,
    @SerializedName("EMAIL") val email: String
)

// Dùng cho đăng nhập (chỉ cần tài khoản + mật khẩu)
data class LoginRequest(
    @SerializedName("USERNAME") val userName: String,
    @SerializedName("PASSWORD") val passWord: String
)

// Phản hồi từ server (có thể dùng chung)
data class RegisterResponse(
    val status: Boolean,
    val message: String,
)

// phản hồi từ server login
data class LoginReponse(
    val status: Boolean,
    val user: UserEntity
)

// phan hoa them hoa don
data class HoaDonRequest(
    @SerializedName("MAND") val MaND: String,
    @SerializedName("THANHTIEN") val thanhTien: Double,
    @SerializedName("DIACHI") val diaChi: String)

data class HoaDonReponse(
    val success:Boolean,
    val message:String,
    val MAHD:String
)

data class UpdatePasswordRequest(
    @SerializedName("MAND") val MaND: String,
    @SerializedName("OLDPASS") val MatKhauCu: String,
    @SerializedName("NEWPASS") val MatKhauMoi: String
)

data class UpdatePasswordResponse(
    val message: String,
    val success: Boolean
)

// phan hoa them chi tiet hoa don
data class HoaDonChiTietRequest(
    @SerializedName("MAHD") val MaHD: String,
    @SerializedName("DONGIA") val donGia: Double,
    @SerializedName("MASP") val MaSP: String,
    @SerializedName("SOLUONG") val soLuong: Double
)

data class HoaDonChiTietReponse(
    val success:Boolean,
    val message:String,
)

data class CapNhapDonHangRequest(
    @SerializedName("MAHD") val MaHD: String,
    @SerializedName("TrangThaiMoi") val TrangThai: String,
)

data class CapNhapDonHangReponse(
    val success:Boolean,
    val message:String,
)


data class CapNhapNguoiDungRequest(
    @SerializedName("MAND") val MaNgD: String,
    @SerializedName("TENND") val TenNgD: String,
    @SerializedName("EMAIL") val Email: String,
    @SerializedName("SDT") val sdt: String
)
data class CapnhapNguoiDungReponse(
    val success: Boolean,
    val message: String
)