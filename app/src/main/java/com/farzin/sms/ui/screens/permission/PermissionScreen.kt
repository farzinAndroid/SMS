package com.farzin.sms.ui.screens.permission

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.farzin.sms.navigation.Screens
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val sendSMSPermission = rememberPermissionState(Manifest.permission.SEND_SMS)
        PermissionRow(
            onPermissionGranted = { },
            checked = sendSMSPermission.status.isGranted,
            onCheckedChange = {
                sendSMSPermission.launchPermissionRequest()
            },
            permissionTxt = "allow send sms permission"
        )
        Button(
            onClick = {
                if (sendSMSPermission.status.isGranted) {
                    navController.navigate(Screens.Main.route) {
                        launchSingleTop = true
                    }
                }
            },
            enabled = sendSMSPermission.status.isGranted

        ) {
            Text(text = "Proceed")
        }

    }

}