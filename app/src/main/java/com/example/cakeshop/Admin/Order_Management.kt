package com.example.cakeshop.Admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen
import com.example.cakeshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Order_Management(navController: NavController) {
    val Orange = Color(0xFFE7A953)
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = { Text("Quản lý đơn hàng") },
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
                        IconButton(onClick = { navController.navigate(Screen.Admin_Home_Page.route) }) {
                            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                        }
                        IconButton(onClick = { navController.navigate(Screen.Revenue_Management.route)}) {
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
                .background(Color(0xFFFFF3E0))
        ) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Tìm kiếm") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                )
            )

            // Order List Header
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text("Danh sách đơn hàng")
                Text("Số lượng: 2")
            }

            // Orders
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(2) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Orange.copy(alpha = 0.2f)
                        ),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text("#Mã đơn hàng ${index + 1}")
                                    Text("#Tên khách hàng ${index + 1}")
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(
                                        onClick = { },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Orange
                                        ),
                                        shape = RoundedCornerShape(0.dp),
                                        modifier = Modifier.height(32.dp)
                                    ) {
                                        Text("Hủy", color = Color.Black)
                                    }
                                    Button(
                                        onClick = { navController.navigate(Screen.Order_Details.route) },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (index == 1) Color.Gray
                                            else Orange.copy(alpha = 0.5f)
                                        ),
                                        modifier = Modifier.height(32.dp),
                                        shape = RoundedCornerShape(0.dp),
                                    ) {
                                        Text(
                                            if (index == 1) "✓" else "Duyệt",
                                            color = Color.Black
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Đã thanh toán: ${if (index == 0) "205.000" else "240.000"} đ",
                                fontSize = 12.sp,
                                color = Color(0xFF4B7449),
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                "Ngày: 01/01/2023",
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

