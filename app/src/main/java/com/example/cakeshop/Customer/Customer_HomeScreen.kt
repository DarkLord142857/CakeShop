package com.example.cakeshop

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen
//123
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Customer_HomeScreen(navController: NavController) {
    val Orange = Color(0xFFE7A953)
    var searchQuery by remember { mutableStateOf("") }

    val products = listOf(
        Product("Tiramisu", 30000, 5, R.drawable.cake),
        Product("Croissant", 30000, 4, R.drawable.cake),
        Product("Pancake", 30000, 4, R.drawable.cake)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Orange
                ),
                title = {
                    Column {
                        Text("GIGACHADCAFE")
                        Text(
                            "Chao buoi sang, Phuong Vo",
                            fontSize = 14.sp
                        )
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
                    onClick = {
                        navController.navigate(Screen.Tracking_Orders.route )
                    }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(id=R.drawable.history),
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
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { }
                )
            }
        },
        
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
                "Danh sách món ăn",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold
            )

            LazyColumn {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        onProductClick = {
                            // Navigate to detail screen
                        },
                        navController
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onProductClick: () -> Unit,
    navController: NavController
) {
    var quantity by remember { mutableStateOf(0) }
    val Orange = Color(0xFFE7A953)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { navController.navigate("productDetail/${product.name}") }
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier.size(80.dp).padding(10.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    product.name,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    repeat(5) { index ->
                        Icon(
                            painter = painterResource(id = R.drawable.ratingcake),
                            contentDescription = "Rating",
                            tint = if (index < product.rating) Orange else Color.Gray,
                            modifier = Modifier.size(18.dp).padding(3.dp)
                        )
                    }
                }
                Text(
                    "${product.price} VND",
                    color = Color.Gray
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { if (quantity > 0) quantity-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Orange)
                ) {
                    Text("Bỏ")
                }
                Text(
                    text = quantity.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Button(
                    onClick = { quantity++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Orange)
                ) {
                    Text("Thêm")
                }
            }
        }
    }
}

data class Product(
    val name: String,
    val price: Int,
    val rating: Int,
    val image: Int
)