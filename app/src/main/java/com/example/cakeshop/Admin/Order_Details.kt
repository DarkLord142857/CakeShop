package com.example.cakeshop.Admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen
import com.example.cakeshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Order_Details(navController: NavController) {
    val Orange = Color(0xFFE7A953)
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(
                        "Chi tiết đơn hàng",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Orange,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Orange,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Orders", tint = Color.Black)
                        }
                        IconButton(onClick = {navController.navigate(Screen.Admin_Home_Page.route) }) {
                            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                        }
                        IconButton(onClick = {navController.navigate(Screen.Revenue_Management.route) }) {
                            Icon(painterResource(R.drawable.memo_circle_check_48), contentDescription = "", tint = Color.Black)
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                "GIGACHADCAFE",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                "CHI TIẾT ĐƠN HÀNG",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(2) {
                        index ->
                    Text("Mã HĐ: Mã hóa đơn ${index + 1}", textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold, modifier = Modifier.fillMaxWidth())
                    Text("Ngày: "+"01/01/2025",  textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())

                    Spacer(modifier = Modifier.height(16.dp))

                    // Order Items Table Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("STT", modifier = Modifier.weight(1f))
                        Text("Tên món", modifier = Modifier.weight(2f))
                        Text("SL", modifier = Modifier.weight(1f))
                        Text("Đơn giá", modifier = Modifier.weight(1.5f))
                        Text("Thành tiền", modifier = Modifier.weight(1.5f))
                    }

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    // Order Items
                    Column {
                        OrderItem(1, "Tiramisu", 1, 150000, 150000)
                        OrderItem(2, "PanCake", 1, 55000, 55000)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Tổng số món: 2")
                       Row(
                           modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.SpaceBetween,
                           verticalAlignment = Alignment.CenterVertically
                       ){
                           Text("Thành tiền: ", fontWeight = FontWeight.Bold)
                           Text("${if (index == 0) "205.000" else "240.000"} đ", fontWeight = FontWeight.Bold)
                       }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Action Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Orange),
                            shape = RoundedCornerShape(0.dp),
                        ) {
                            Text("Hủy", color = Color.Black)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (index == 1) Color.Gray
                                else Orange.copy(alpha = 0.5f)
                            ),
                            shape = RoundedCornerShape(0.dp),
                        ) {
                            Text(
                                if (index == 1) "✓" else "Duyệt",
                                color = Color.Black
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
private fun OrderItem(
    stt: Int,
    name: String,
    quantity: Int,
    price: Int,
    total: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(stt.toString(), modifier = Modifier.weight(1f))
        Text(name, modifier = Modifier.weight(2f))
        Text(quantity.toString(), modifier = Modifier.weight(1f))
        Text(price.toString(), modifier = Modifier.weight(1.5f))
        Text(total.toString(), modifier = Modifier.weight(1.5f))
    }
    Divider(modifier = Modifier.padding(vertical = 4.dp))
}