import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeshop.Navigation.Screen
import com.example.cakeshop.R

@Composable
fun CustomerProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE4B37C))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Thông tin khách hàng",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }

            // Profile Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Profile Image
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Customer Information
                Text(
                    text = "VÕ THÀNH PHUONG",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Thông tin khách hàng:", fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Số điện thoại: 0362916264")
                Text(text = "Email: thphuong000@gmail")
                Text(text = "Địa chỉ: Thành phố Hồ Chí Minh")
            }

            Spacer(modifier = Modifier.weight(1f))

            // Logout Button
            Button(
                onClick = { /* Handle logout */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE4B37C)
                )
            ) {
                Text(
                    text = "Đăng xuất",
                    color = Color.Black
                )
            }

            // Bottom Navigation
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color(0xFFE4B37C)
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    selected = false,
                    onClick = { /* Handle cart click */ },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFE4B37C)
                    )
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
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    selected = false,
                    onClick = { /* Handle home click */ },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFE4B37C)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    selected = true,
                    onClick = { /* Handle profile click */ },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFE4B37C)
                    )
                )
            }
        }
    }
}
