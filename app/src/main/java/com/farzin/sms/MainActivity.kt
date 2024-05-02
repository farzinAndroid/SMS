package com.farzin.sms

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.farzin.sms.data.SMSReceiver
import com.farzin.sms.navigation.NavGraph
import com.farzin.sms.navigation.Screens
import com.farzin.sms.ui.screens.main.MainScreen
import com.farzin.sms.ui.theme.SMSTheme
import com.farzin.sms.util.PermissionHelper.isPermissionsGranted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                    val startDestination =
                        if (isPermissionsGranted(this)) Screens.Main.route
                        else Screens.Permission.route

                    try {
                        // register the broadcast receiver to catch the incoming messages
                        var filter = IntentFilter()
                        filter.addAction("om.farzin.sms.data.SMSReceiver")
                        val receiver = SMSReceiver()
                        registerReceiver(receiver, filter, RECEIVER_NOT_EXPORTED)
                        sendBroadcast(Intent("om.farzin.sms.data.SMSReceiver"))
                    } catch (e: Exception) {
                        Log.e("TAG",e.message.toString())
                    }

                    NavGraph(navController = navController, startDestination = startDestination)
                }
            }
        }
    }


}