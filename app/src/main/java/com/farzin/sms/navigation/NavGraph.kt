package com.farzin.sms.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.farzin.sms.ui.screens.main.MainScreen
import com.farzin.sms.ui.screens.permission.PermissionScreen

@Composable
fun NavGraph(navController: NavHostController,startDestination:String) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable(Screens.Permission.route){
            PermissionScreen(navController)
        }

        composable(Screens.Main.route){
            MainScreen()
        }

    }

}