package com.farzin.sms.ui.screens.permission

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.farzin.sms.navigation.Screens
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState


@SuppressLint("SuspiciousIndentation")
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
            checked = sendSMSPermission.status.isGranted,
            onCheckedChange = {
                sendSMSPermission.launchPermissionRequest()
            },
            permissionTxt = "Allow send sms permission"
        )

        val readSMSPermission = rememberPermissionState(Manifest.permission.READ_SMS)
        PermissionRow(
            checked = readSMSPermission.status.isGranted,
            onCheckedChange = {
                readSMSPermission.launchPermissionRequest()
            },
            permissionTxt = "Allow read sms permission"
        )

        val receiveSMSPermission = rememberPermissionState(Manifest.permission.RECEIVE_SMS)
        PermissionRow(
            checked = receiveSMSPermission.status.isGranted,
            onCheckedChange = {
                receiveSMSPermission.launchPermissionRequest()
            },
            permissionTxt = "Allow receive sms permission"
        )


        val notificationPermission = rememberPermissionState(Manifest.permission.POST_NOTIFICATIONS)
        PermissionRow(
            checked = notificationPermission.status.isGranted,
            onCheckedChange = {
                notificationPermission.launchPermissionRequest()
            },
            permissionTxt = "Allow send notification permission"
        )






        Button(
            onClick = {
                if (sendSMSPermission.status.isGranted && notificationPermission.status.isGranted) {
                    navController.navigate(Screens.Main.route) {
                        popUpTo(Screens.Permission.route) {
                            inclusive = true
                        }
                    }
                }
            },
            enabled = sendSMSPermission.status.isGranted && notificationPermission.status.isGranted,
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(text = "Proceed")
        }

    }

}