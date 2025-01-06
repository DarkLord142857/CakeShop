package com.example.cakeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cakeshop.Navigation.NavGraph
import com.example.cakeshop.ui.theme.CakeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var navController: NavHostController
        super.onCreate(savedInstanceState)
        setContent {
            CakeShopTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

