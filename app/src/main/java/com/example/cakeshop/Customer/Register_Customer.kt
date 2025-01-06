package com.example.cakeshop.Customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
fun Register_Customer(navController: NavController){
    val Orange = Color(0xFFE7A953)
    var userName by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    var reEnterPassWord by remember { mutableStateOf("") }
    var textTrue by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    Scaffold (
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = { Text("") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Orange,
                    navigationIconContentColor = Color.Black
                )
            )
        }
    ){
        paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(bottom = 30.dp),
                text = "ĐĂNG KÝ",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold)
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
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password)

                )
                OutlinedTextField(
                    modifier = Modifier.padding(5.dp),
                    value = passWord,
                    onValueChange = {passWord = it},
                    label = { Text(text = "Mật khẩu") },
                    shape = RoundedCornerShape(20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )
                OutlinedTextField(
                    modifier = Modifier.padding(5.dp),
                    value = reEnterPassWord,
                    onValueChange = {reEnterPassWord = it},
                    label = { Text(text = "Nhập lại mật khẩu") },
                    shape = RoundedCornerShape(20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Button(
                modifier = Modifier.padding(horizontal = 100.dp),
                colors = ButtonDefaults.buttonColors(Orange),
                onClick = {
                    if(passWord.length >= 8 && passWord == reEnterPassWord){
                        navController.navigate(Screen.Login_Customer.route)
                    }
                    else if(passWord != reEnterPassWord){
                        textTrue = "Xin vui lòng nhập lại mật khẩu"
                    }
                    else{
                        textTrue = "Yêu cầu mật khẩu nhiều hơn 8 ký tự"
                    }
                    if(userName.isEmpty() || passWord.isEmpty() || reEnterPassWord.isEmpty()){
                        error = "Xin vui lòng nhập đầy đủ thông tin không được để trống"
                    }
                }
            ) {
                Text(text = "Đăng ký", color = Color.Black)
            }
            if (textTrue.isNotEmpty() && userName.isNotEmpty() && passWord.isNotEmpty() && reEnterPassWord.isNotEmpty()){
                Text(text = textTrue, color = Color.Blue, fontSize = 15.sp)
            }else{
                Text(text = error, color = Color.Blue, fontSize = 15.sp)
            }
        }

    }
    }
