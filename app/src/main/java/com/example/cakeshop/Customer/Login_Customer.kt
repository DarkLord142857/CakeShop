package com.example.cakeshop.Customer

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import com.example.cakeshop.R
import com.example.cakeshop.Navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login_Customer(navController: NavController) {
    val Orange = Color(0xFFE7A953)
    var userName by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
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
            fontWeight = FontWeight.ExtraBold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier.padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                onClick = { navController.navigate(Screen.Login_Admin.route)},
            ) {
                Text(text = "Quản lý", color = Color.Black)
            }
            Button(
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                onClick = {

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
                value = userName,
                onValueChange = {userName = it},
                label = { Text(text = "Tên tài khoản") },
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password)

            )
            OutlinedTextField(
                modifier = Modifier.padding(5.dp),
                value = passWord,
                onValueChange = {passWord = it},
                label = { Text(text = "Mật khẩu") },
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
                visualTransformation =  PasswordVisualTransformation()
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
                    navController.navigate(Screen.Customer_Home_Page.route)
                },

                ) {
                Text(text = "Đăng nhập", color = Color.Black)
            }
            Button(
                colors = ButtonDefaults.buttonColors(Orange),
                onClick = {
                    navController.navigate(Screen.Register_Customer.route)
                }
            ) {
                Text(text = "Đăng ký", color = Color.Black)
            }
        }
    }
}