package com.example.cakeshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pay_Customer(orderId: String?, navController: NavController) {
    val Orange = Color(0xFFE7A953)

    val items = listOf(
        OrderItem("Tiramisu", 1, 150000),
        OrderItem("Croissaint", 3, 30000)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Orange
                ),
                title = { Text("Đặt hàng") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Orange
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                    label = { Text("Cart") },
                    selected = false,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(id = R.drawable.history),
                        modifier = Modifier.size(30.dp), contentDescription = "History") },
                    label = { Text("History") },
                    selected = true,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Text(
                text = "GIGACHADCAFE",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "CHI TIẾT ĐƠN HÀNG",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Mã HĐ: Mã hóa đơn 2",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Text(
                text = "Ngày: 01/01/2025",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            // Table Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("STT", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("Tên món", modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
                Text("SL", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("Đơn giá", modifier = Modifier.weight(1.5f), textAlign = TextAlign.Center)
                Text("Thành tiền", modifier = Modifier.weight(1.5f), textAlign = TextAlign.Center)
            }

            // Table Content
            items.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${index + 1}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text(item.name, modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
                    Text("${item.quantity}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("${item.price}", modifier = Modifier.weight(1.5f), textAlign = TextAlign.Center)
                    Text("${item.price * item.quantity}", modifier = Modifier.weight(1.5f), textAlign = TextAlign.Center)
                }
            }
            // Total
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Tổng số món: ${items.sumOf { it.quantity }}")
                Text("Thành tiền: ${items.sumOf { it.price * it.quantity }} đ")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Orange)
                ) {
                    Text("Thanh toán ${items.sumOf { it.price*it.quantity }}")
                }}
        }
    }
}


