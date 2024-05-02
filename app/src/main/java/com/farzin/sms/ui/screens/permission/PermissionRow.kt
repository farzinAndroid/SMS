package com.farzin.sms.ui.screens.permission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PermissionRow(
    onPermissionGranted: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    permissionTxt: String,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = permissionTxt)

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )

        if (checked) {
            onPermissionGranted()
        }

    }

}