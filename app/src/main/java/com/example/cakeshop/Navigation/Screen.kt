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
    object Customer_Home_Page:Screen(route="customer_home_page")
    object Detail_ProductScreen:Screen(route="detail_product_screen")
    object Product_History: Screen(route = "product_history_screen")
    object Tracking_Orders: Screen(route = "tracking_orders_screen")
    object Receipt: Screen(route = "receipt_screen")
    object Order: Screen(route = "order_screen")
    object Pay: Screen(route = "pay_screen")
    object Profile: Screen(route = "profile_screen")
}