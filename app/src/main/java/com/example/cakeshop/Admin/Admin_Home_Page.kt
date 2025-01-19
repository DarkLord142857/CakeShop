package com.example.cakeshop.Admin

import androidx.compose.material3.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeshop.R
import com.example.cakeshop.Navigation.Screen
import android.compose.material3.TopAppBar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Admin_Home_Page(navController: NavController){
    val Orange = Color(0xFFE7A953)
    Scaffold (
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Orange,
                    titleContentColor = Color.Black
                ),
                title = {
                  Text(text = "GIGACHADCAFE",
                      fontSize = 16.sp,
                      modifier = Modifier.fillMaxWidth(),
                      textAlign = TextAlign.Center)
                }
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
                        IconButton(onClick = {
                            navController.navigate(Screen.Order_Management.route)
                        }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Orders", tint = Color.Black)
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                        }
                        IconButton(onClick = {
                            navController.navigate(Screen.Revenue_Management.route)
                        }) {
                            Icon(painterResource(R.drawable.memo_circle_check_48), contentDescription = "", tint = Color.Black)
                        }
                    }
                }
            )
        }
    )
    { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.cake),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize(),
            )

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Location Box
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .background(Orange)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.LocationOn,
                            contentDescription = "Location",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                "Địa chỉ cửa hàng:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                            Text(
                                "299 Huỳnh Thúc Kháng",
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }
                    }
                }

                // Management Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.Order_Management.route) },
                        colors = ButtonDefaults.buttonColors(containerColor = Orange),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Quản lý\nđơn hàng",
                                color = Color.Black,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                            Icon(
                                Icons.Filled.ShoppingCart,
                                contentDescription = "Orders",
                                tint = Color.Black
                            )
                        }
                    }

                    Button(
                        onClick = { navController.navigate(Screen.Revenue_Management.route)},
                        colors = ButtonDefaults.buttonColors(containerColor = Orange),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Quản lý\nDoanh số",
                                color = Color.Black,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                            Icon(
                                Icons.Filled.LocationOn,
                                contentDescription = "Revenue",
                                tint = Color.Black
                            )
                        }
                    }
                }

                // Logout Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.Login_Admin.route)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Orange),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            "Đăng xuất",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}
