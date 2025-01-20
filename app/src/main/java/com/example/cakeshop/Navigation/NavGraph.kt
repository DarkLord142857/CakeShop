package com.example.cakeshop.Navigation
import CustomerProfileScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cakeshop.Admin.Admin_Home_Page
import com.example.cakeshop.Admin.Login_Admin
import com.example.cakeshop.Admin.Order_Details
import com.example.cakeshop.Admin.Order_Management
import com.example.cakeshop.Admin.Register_Manager
import com.example.cakeshop.Admin.Revenue_Management
import com.example.cakeshop.Customer.Login_Customer
import com.example.cakeshop.Customer.Register_Customer
import com.example.cakeshop.Customer_HomeScreen
import com.example.cakeshop.Order_Customer
import com.example.cakeshop.Pay_Customer
import com.example.cakeshop.ProductDetailScreen
import com.example.cakeshop.ProductHistoryScreen
import com.example.cakeshop.ReceiptScreen
import com.example.cakeshop.RoomDatabase.AppDatabase
import com.example.cakeshop.RoomDatabase.UserRoom.UserEntity
import com.example.cakeshop.TrackingOrdersScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


sealed class Screen(val route: String){
    object Login_Admin: Screen(route = "login_admin_screen")
    object Login_Customer: Screen(route = "login_customer_screen")
    object Register_Admin: Screen(route = "register_manager_screen")
    object Register_Customer: Screen(route = "register_customer_screen")
    object Admin_Home_Page: Screen(route = "admin_home_page_screen")
    object Order_Management: Screen(route = "order_management_screen")
    object Order_Details:Screen(route = "order_details_screen")
    object Revenue_Management:Screen(route = "revenue_management_screen")
    object Customer_Home_Page:Screen(route="customer_home_page")
    object Detail_ProductScreen:Screen(route="detail_product_screen")
    object Product_History: Screen(route = "product_history_screen")
    object Tracking_Orders: Screen(route = "tracking_orders_screen")
    object Receipt: Screen(route = "receipt_screen")
    object Order: Screen(route = "order_screen")
    object Pay: Screen(route = "pa y_screen")
    object Profile: Screen(route = "profile_screen")
}

@Composable
fun AccountNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current // Lấy context tại đây để truyền vào nếu cần

    // Lấy SharedPreferences để kiểm tra trạng thái đăng nhập
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    val isLoggedIn = sharedPreferences.getBoolean("is_logged_in", false)

    // Lấy danh sách người dùng từ cơ sở dữ liệu Room
    val db = AppDatabase.getDatabase(context) // Sử dụng AppDatabase của Room

    // State lưu trữ danh sách người dùng
    var userList by remember { mutableStateOf<List<UserEntity>>(emptyList()) }

    // Sử dụng LaunchedEffect để thực hiện điều hướng khi trạng thái đăng nhập thay đổi
    LaunchedEffect(Unit) {
        // Thực hiện truy vấn cơ sở dữ liệu trong background thread
        userList = withContext(Dispatchers.IO) {
            db.UserDao().getAll()
        }

        // Kiểm tra nếu người dùng đã đăng nhập và có người dùng hợp lệ trong DB
        if (userList.isNotEmpty()) {
            // Nếu người dùng đã đăng nhập và có người dùng hợp lệ trong DB, điều hướng đến HomeScreen
            val user = userList[0]
            if (user.chucVu.equals("KhachHang")) {
                navController.navigate(Screen.Customer_Home_Page.route) {
                    popUpTo(Screen.Login_Customer.route) { inclusive = true }
                }
            }

            if (user.chucVu.equals("QuanLy")) {
                navController.navigate(Screen.Admin_Home_Page.route) {
                    popUpTo(Screen.Login_Admin.route) { inclusive = true }
                }
            }

        } else {
            // Nếu không có người dùng hợp lệ, điều hướng đến LoginScreen
            navController.navigate(Screen.Login_Admin.route)
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Login_Admin.route
    ) {
        composable(route = Screen.Login_Customer.route){
            Login_Customer(navController)
        }
        composable(route = Screen.Login_Admin.route){
            Login_Admin(navController)
        }
        composable(route = Screen.Register_Admin.route){
            Register_Manager(navController)
        }
        composable(route = Screen.Register_Customer.route){
            Register_Customer(navController)
        }
        composable(route = Screen.Admin_Home_Page.route){
            Admin_Home_Page(navController)
        }
        composable(route = Screen.Order_Management.route){
            Order_Management(navController)
        }
        composable(route = Screen.Order_Details.route){
            Order_Details(navController)
        }
        composable(route = Screen.Revenue_Management.route){
            Revenue_Management(navController)
        }
        composable(route = Screen.Customer_Home_Page.route){
            Customer_HomeScreen(navController)
        }
        composable(route = Screen.Product_History.route) {
            ProductHistoryScreen(navController)
        }
        composable(route = Screen.Tracking_Orders.route) {
            TrackingOrdersScreen(navController)
        }
        composable(route = Screen.Profile.route) {
            CustomerProfileScreen(navController)
        }
        composable(
            "productDetail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailScreen(productId, navController)
        }
        composable(
            "receipt/{orderId}",
            arguments = listOf(navArgument("orderId") { type = NavType.StringType })
        ) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")
            ReceiptScreen(orderId, navController)
        }
        composable(Screen.Order.route) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")
            Order_Customer(orderId, navController)
        }
        composable(Screen.Pay.route) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")
            Pay_Customer(orderId, navController)
        }
    }
}


