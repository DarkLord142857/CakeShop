package com.example.cakeshop.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cakeshop.RoomDatabase.UserRoom.UserEntity
import com.example.cakeshop.api.ApiService
import com.example.cakeshop.api.RetrofitInstance
import com.example.cakeshop.data.CapNhapNguoiDungRequest
import com.example.cakeshop.data.LoginRequest
import com.example.cakeshop.data.RegisterRequest
import com.example.cakeshop.data.UpdatePasswordRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AccountViewModel: ViewModel() {

    val apiService: ApiService = RetrofitInstance.api

    private val _dangKyThanhCong = MutableStateFlow<Boolean?>(null)
    val dangKyThanhCong: StateFlow<Boolean?> = _dangKyThanhCong

    suspend fun dangKyNguoiDung(tenNgD: String, sdt: String, tkNgD: String, matKhauNgD: String,Email:String) {
        try {
            val response = apiService.dangky(RegisterRequest(tenNgD, sdt, tkNgD, matKhauNgD,Email))
            Log.d("API", "Đăng ký thành công: ${response}")
            // Cập nhật trạng thái đăng ký
            _dangKyThanhCong.value = response.status
        } catch (e: Exception) {
            Log.e("API", "Lỗi đăng ký: ${e.message}")
        }
    }


    private  val _dangNhapThanhCong=MutableStateFlow<Boolean?>(null)
    val dangNhapThanhCong:StateFlow<Boolean?> = _dangNhapThanhCong

    private  val _duLieuNguoiDung=MutableStateFlow<UserEntity?>(null)
    val duLieuNguoiDung:StateFlow<UserEntity?> = _duLieuNguoiDung

    suspend fun dangNhapNguoiDung( userName: String, passWord: String) {
        try {
            val response = apiService.dangnhap(LoginRequest(userName, passWord))
            Log.d("API", "Đăng nhap thành công: ${response}")
            _dangNhapThanhCong.value=response.status
            _duLieuNguoiDung.value= response.user
        } catch (e: Exception) {
            Log.e("API", "Lỗi đăng nhap: ${e.message}")
        }
    }


    private val _capNhatMatKhauThanhCong = MutableStateFlow<Boolean?>(null)
    val capNhatMatKhauThanhCong: StateFlow<Boolean?> = _capNhatMatKhauThanhCong

    private val _thongbaocapnhatmatkhau = MutableStateFlow<String?>(null)
    val thongbaocapnhatmatkhau: StateFlow<String?> = _thongbaocapnhatmatkhau

    suspend fun capNhatMatKhau(MaNgD: String, MatKhauCu: String, MatKhauMoi: String) {
        try {
            val response = apiService.capnhatmatkhau(UpdatePasswordRequest(MaNgD, MatKhauCu, MatKhauMoi))
            Log.d("API", "Cập nhật mật khẩu: ${response}")
            _capNhatMatKhauThanhCong.value=response.success
            _thongbaocapnhatmatkhau.value= response.message
        } catch (e: Exception) {
            Log.e("API", "Lỗi cập nhật mật khẩu: ${e.message}")
            _capNhatMatKhauThanhCong.value = false // Lỗi ngoại lệ
        }
    }

    fun resetPasswordChangeState() {
        _capNhatMatKhauThanhCong.value = null
        _thongbaocapnhatmatkhau.value = null
    }


}