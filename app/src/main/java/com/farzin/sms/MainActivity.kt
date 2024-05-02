package com.farzin.sms

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.farzin.sms.navigation.NavGraph
import com.farzin.sms.navigation.Screens
import com.farzin.sms.ui.screens.main.MainScreen
import com.farzin.sms.ui.theme.SMSTheme
import com.farzin.sms.util.PermissionHelper.isPermissionsGranted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val startDestination =
                        if (isPermissionsGranted(this)) Screens.Main.route
                        else Screens.Permission.route

                    NavGraph(navController = navController, startDestination = startDestination)
                }
            }
        }
    }


}