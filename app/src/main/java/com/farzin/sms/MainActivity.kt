package com.farzin.sms

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.farzin.sms.navigation.NavGraph
import com.farzin.sms.navigation.Screens
import com.farzin.sms.ui.theme.SMSTheme
import com.farzin.sms.util.PermissionHelper.isNotificationPermissionsGranted
import com.farzin.sms.util.PermissionHelper.isSMSPermissionsGranted
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    // check if the permissions are granted and based
                    // on that navigate to appropriate destination
                    val startDestination =
                        if (isSMSPermissionsGranted(this)
                            && isNotificationPermissionsGranted(this)) Screens.Main.route
                        else Screens.Permission.route

                    NavGraph(navController = navController, startDestination = startDestination)
                }
            }
        }
    }


}