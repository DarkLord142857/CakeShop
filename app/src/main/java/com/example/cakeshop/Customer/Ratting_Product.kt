package com.example.cakeshop.Customer

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen
import com.example.cakeshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductRatingScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top Bar
        TopAppBar(
            title = { Text("Đánh giá sản phẩm") },
            navigationIcon = {
                IconButton(onClick = { /* Handle back */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            modifier = Modifier.background(Color(0xFFDEB887))
        )

        // Content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Text(
                text = "Hãy đánh giá\nsản phẩm",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Tiramisu Rating
            ProductRatingItem(
                productName = "Tiramisu:",
                rating = remember { mutableStateOf(0) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // PanCake Rating
            ProductRatingItem(
                productName = "PanCake:",
                rating = remember { mutableStateOf(0) }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Submit Button
            Button(
                onClick = { /* Handle submit */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4169E1))
            ) {
                Text("Gửi")
            }
        }

        // Bottom Navigation
        NavigationBar(
            modifier = Modifier.background(Color(0xFFDEB887))
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.ShoppingCart, "Cart") },
                selected = false,
                onClick = { /* Handle navigation */ }
            )
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id= R.drawable.history),
                    modifier = Modifier.size(30.dp), contentDescription = "History") },
                label = { Text("History") },
                selected = false,
                onClick = {
                    navController.navigate(Screen.Product_History.route)
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, "Home") },
                selected = false,
                onClick = { /* Handle navigation */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, "Profile") },
                selected = false,
                onClick = { /* Handle navigation */ }
            )
        }
    }
}

@Composable
fun ProductRatingItem(
    productName: String,
    rating: MutableState<Int>
) {
    Column {
        Text(
            text = productName,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(5) { index ->
                IconButton(
                    onClick = { rating.value = index + 1 }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ratingcake),
                        contentDescription = "Rate $index",
                        tint = if (index < rating.value) Color(0xFF000000) else Color.LightGray
                    )
                }
            }
        }
    }
}