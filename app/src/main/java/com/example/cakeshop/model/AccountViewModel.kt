package com.example.cakeshop.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cakeshop.api.RetrofitClient
import com.example.cakeshop.data.TaiKhoanQL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel: ViewModel()
{
//    var taikhoanQL :TaiKhoanQL by mutableStateOf(TaiKhoanQL("","","","","",""))
//
//    var trangthaiDangNhap: Boolean = false
//
//    var listdangnhap : List<TaiKhoanQL> by mutableStateOf(emptyList())
//
//    fun kiemtraTrangThai(){
//        if(taikhoanQL.idQL.isNotEmpty()){
//            trangthaiDangNhap = false
//        }
//        else{
//            trangthaiDangNhap = true
//        }
//    }
//
//    var dangnhap :TaiKhoanQL by mutableStateOf(TaiKhoanQL("","","","","",""))
//
//    fun getTaiKhoanMatKhau(username: String, password: String){
//        viewModelScope.launch (Dispatchers.IO){
//            try{
//                listdangnhap = RetrofitClient.apiService.kiemTraDangNhap(username, password)
//                dangnhap = listdangnhap[0]
//            }
//            catch (e: Exception){
//                Log.e("DangNhapViewModel","Error: ${e.message}")
//            }
//        }
//
//    }
}