package com.example.cakeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cakeshop.Navigation.AccountNavigation
import com.example.cakeshop.ui.theme.CakeShopTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CakeShopTheme {
                AccountNavigation()
            }
        }
    }
}

