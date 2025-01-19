package com.example.cakeshop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackingOrdersScreen(navController: NavController) {
    val Orange = Color(0xFFE7A953)
    var searchQuery by remember { mutableStateOf("") }

    val orders = listOf(
        TrackingOrder(
            id = "Mã đơn hàng 1",
            customerName = "Tên khách hàng 1",
            status = "Đang xử lí",
            total = 205000,
            date = "01/01/2025",
            paymentStatus = "Đã thanh toán"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Orange
                ),
                title = { Text("Theo dõi đơn hàng") },
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
                    selected = true,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(id = R.drawable.history),
                        modifier = Modifier.size(30.dp), contentDescription = "History") },
                    label = { Text("History") },
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Product_History.route)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Customer_Home_Page.route)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Profile.route)
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Tìm kiếm") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
            )

            Text(
                "Danh sách đơn hàng",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontWeight = FontWeight.Bold
            )

            Text(
                "Số lượng: ${orders.size}",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color.Gray
            )

            LazyColumn {
                items(orders) { order ->
                    TrackingOrderItem(
                        order = order,
                        onOrderClick = {
                            navController.navigate("receipt/${order.id}")
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun TrackingOrderItem(
    order: TrackingOrder,
    onOrderClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onOrderClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF8DC)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "#${order.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "#${order.customerName}",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = order.status,
                    color = Color(0xFFFFA500),
                    fontSize = 14.sp
                )
                Text(
                    text = "${order.total} đ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = order.paymentStatus,
                    color = Color(0xFF4CAF50),
                    fontSize = 12.sp
                )
                Text(
                    text = "Ngày: ${order.date}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}
data class TrackingOrder(
    val id: String,
    val customerName: String,
    val status: String,
    val total: Int,
    val date: String,
    val paymentStatus: String
)