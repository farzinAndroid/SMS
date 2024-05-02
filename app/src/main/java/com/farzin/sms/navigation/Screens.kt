package com.farzin.sms.navigation

sealed class Screens(val route:String) {

    data object Main : Screens(route = "main_screen")
    data object Permission : Screens(route = "permission_screen")

}