package com.example.cakeshop.Navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cakeshop.Admin.Admin_Home_Page
import com.example.cakeshop.Admin.Login_Admin
import com.example.cakeshop.Admin.Order_Details
import com.example.cakeshop.Admin.Order_Management
import com.example.cakeshop.Admin.Register_Manager
import com.example.cakeshop.Admin.Revenue_Management
import com.example.cakeshop.Customer.Login_Customer
import com.example.cakeshop.Customer.Register_Customer


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
    }
}