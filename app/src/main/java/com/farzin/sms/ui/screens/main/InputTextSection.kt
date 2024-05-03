package com.farzin.sms.ui.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputTextSection(
    smsMessage:String,
    onValueChange:(String)->Unit,
    onSendClick:()->Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {

            onSendClick()
        }) {
            Icon(
                imageVector = Icons.Rounded.Send,
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }

        TextField(
            value = smsMessage,
            onValueChange = { newText ->
                onValueChange(newText)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 8.dp),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.LightGray,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = Shapes().large,
            placeholder = {
                Text(text = "Enter SMS message", color = Color.Gray)
            }
        )
    }


}