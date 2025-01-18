package com.example.cakeshop.Navigation
import CustomerProfileScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
import com.example.cakeshop.TrackingOrdersScreen
import com.example.cakeshop.model.AccountViewModel

//456
@Composable
fun NavGraph(navController: NavHostController){

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