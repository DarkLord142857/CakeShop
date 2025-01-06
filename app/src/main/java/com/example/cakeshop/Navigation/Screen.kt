package com.example.cakeshop.Navigation

sealed class Screen(val route: String){
    object Login_Admin: Screen(route = "login_admin_screen")
    object Login_Customer: Screen(route = "login_customer_screen")
    object Register_Admin: Screen(route = "register_manager_screen")
    object Register_Customer: Screen(route = "register_customer_screen")
    object Admin_Home_Page: Screen(route = "admin_home_page_screen")
    object Order_Management: Screen(route = "order_management_screen")
    object Order_Details:Screen(route = "order_details_screen")
    object Revenue_Management:Screen(route = "revenue_management_screen")
}