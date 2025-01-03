package com.example.cakeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Admin_Home_Page(navController: NavController){
    val Orange = Color(0xFFE7A953)
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Orange,
                    titleContentColor = Color.Black
                ),
                title = {
                  Box(
                      modifier = Modifier.fillMaxWidth()
                          .height(20.dp),
                      contentAlignment = Alignment.Center
                  ){
                      Text(text = "GIGACHADCAFE", fontSize = 16.sp)
                  }
                }
            )
        }
    ){
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.cake),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
        }
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.padding(40.dp).background(Orange)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Filled.LocationOn,
                        contentDescription = null)
                    Column {
                        Text(text = "Địa chỉ cửa hàng: ", fontWeight = FontWeight.ExtraBold)
                        Text(text = "299 Huỳnh Thúc Kháng")
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                   Box(
                       modifier = Modifier.padding(5.dp)
                   ){
                       Row (
                           modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.SpaceEvenly
                       ){
                           Button(onClick = {}, colors = ButtonDefaults.buttonColors(Orange)) {
                               IconChild(Icons.Filled.ShoppingCart, "Quản lý \n đơn hàng",Color.Black)}
                           Button(onClick = {}, colors =ButtonDefaults.buttonColors(Orange)) {
                               IconChild(Icons.Filled.AddCircle, "Quản lý \n Doanh số",Color.Black) }

                       }
                }
                }
            Row(  modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically){
                Button(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 80.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Orange),
                ) {
                    Text(text = "Đăng xuất", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, color = Color.Black)
                }
            }
            }
        }
}
@Composable
fun IconChild(icon: ImageVector, lable:String="",iconColor: Color = Color.Black){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = lable, color = Color.Black)
        Icon(icon, contentDescription = lable, tint = iconColor)
    }
}