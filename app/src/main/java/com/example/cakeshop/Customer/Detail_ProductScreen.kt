package com.example.cakeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(product: String?, navController: NavController) {
    val Orange = Color(0xFFE7A953)
    var quantity by remember { mutableStateOf(1) }
    val orders = listOf(
        Order(
            id = "Mã đơn hàng 2",
            name = "",
            customerName = "Tên khách hàng 2",
            total = 240000,
            date = "01/01/2025",
            status = "Đã thanh toán"
        )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Orange
                ),
                title = { Text("GIGACHADCAFE") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.cake),
                contentDescription = "Tiramisu",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Mô tả:",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "một loại bánh ngọt tráng miệng vị cà phê của nước Ý, gồm các lớp bánh quy Savoiardi, những cà phê xen kẽ với hỗn hợp trứng, đường, phô mai mascarpone đánh bông, thêm một ít bột cacao."
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Đánh giá:",
                    fontWeight = FontWeight.Bold
                )
                Row {
                    repeat(5) {
                        Icon(
                            painter = painterResource(id = R.drawable.ratingcake),
                            contentDescription = "Rating",
                            tint = Orange,
                            modifier = Modifier.size(24.dp).padding(3.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Tiramisu",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "30.000 VND",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { if (quantity > 1) quantity-- },
                        colors = ButtonDefaults.buttonColors(containerColor = Orange)
                    ) {
                        Text("Bỏ")
                    }
                    Text(quantity.toString())
                    Button(
                        onClick = { quantity++ },
                        colors = ButtonDefaults.buttonColors(containerColor = Orange)
                    ) {
                        Text("Thêm")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {navController.navigate(Screen.Order.route)},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Orange)
                ) {
                    Text("Đặt")
                }
            }
        }
    }
}
