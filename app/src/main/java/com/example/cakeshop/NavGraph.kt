package com.example.cakeshop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


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
    }
}