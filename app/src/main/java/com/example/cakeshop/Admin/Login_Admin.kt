package com.example.cakeshop.Admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen
import com.example.cakeshop.R
import com.example.cakeshop.api.ApiService
import com.example.cakeshop.api.LoginResponse
import com.example.cakeshop.data.TaiKhoanQL
import com.example.cakeshop.model.AccountViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login_Admin(navController: NavController) {
    val Orange = Color(0xFFE7A953)
    var adminName by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()
    ){
      Image(
          painter = painterResource(id = R.drawable.cake),
          contentDescription = "",
          contentScale = ContentScale.FillBounds,
          modifier = Modifier.matchParentSize()
      )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
            Text(
                modifier = Modifier.padding(bottom = 30.dp),
                text = "ĐĂNG NHẬP",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
                )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier.padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                onClick = {},
            ) {
                Text(text = "Quản lý", color = Color.Black)
            }
            Button(
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                onClick = {
                    navController.navigate(Screen.Login_Customer.route)
                }
            ) {
                Text(text = "Khách hàng", color = Color.Black)
            }
        }
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End,

        ){
            OutlinedTextField(
                modifier = Modifier.padding(5.dp),
                value = adminName,
                onValueChange = {adminName = it},
                label = {Text(text = "admin1",color = Color.Black)},
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Text)

            )
            OutlinedTextField(
                modifier = Modifier.padding(5.dp),
                value = passWord,
                onValueChange = {passWord = it},
                label = {Text(text = "Mật khẩu",color = Color.Black)},
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
        }

        errorMessage.let{
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Orange),
                modifier = Modifier.padding(horizontal = 20.dp),
                onClick = {
                    if((adminName.equals("admin1") && passWord.equals("123456"))||(adminName.equals("admin2") && passWord.equals("123456")))
                    {
                        navController.navigate(Screen.Admin_Home_Page.route)
                    }
                    else
                    {
                        errorMessage = "Sai tài khoản hoặc mật khẩu"
                    }
                },
            ) {
                Text(text = "Đăng nhập", color = Color.Black)
            }
            Button(
                colors = ButtonDefaults.buttonColors(Orange),
                onClick = {
                    navController.navigate(Screen.Register_Admin.route)
                }
            ) {
                Text(text = "Đăng ký", color = Color.Black)
            }
        }
    }
    if (showDialog) {
        handleLoginResult(
            isSuccess = isSuccess,
            errorMessage = errorMessage,
            onDismiss = { showDialog = false },
            navController
        )
    }
}

@Composable
fun showSuccessDialog(onDismiss: () -> Unit,navController: NavController) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Đăng Nhập Thành Công") },
        text = { Text(text = "Chào mừng bạn đã đăng nhập thành công!") },
        confirmButton = {
            Button(onClick = {
                onDismiss()
                navController.navigate(Screen.Admin_Home_Page.route)
            }) {
                Text("OK")
            }
        }
    )
}

@Composable
fun showFailureDialog(errorMessage: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Đăng Nhập Thất Bại") },
        text = { Text(text = "Đăng nhập không thành công. \nLỗi: $errorMessage") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Thử lại")
            }
        }
    )
}


@Composable
fun handleLoginResult(
    isSuccess: Boolean,
    errorMessage: String = "",
    onDismiss: () -> Unit,
    navController: NavController
) {
    if (isSuccess) {
        showSuccessDialog(onDismiss = onDismiss,navController)
    } else {
        showFailureDialog(errorMessage = errorMessage, onDismiss = onDismiss)
    }
}