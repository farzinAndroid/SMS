package com.farzin.sms.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.sms.viewModel.SMSViewmodel

@Composable
fun MainScreen(smsViewmodel: SMSViewmodel = hiltViewModel()) {

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var smsMessage by remember {
        mutableStateOf("")
    }



    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp)
        )

        TextField(
            value = smsMessage,
            onValueChange = {
                smsMessage = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp)
        )

        Button(onClick = {
            if (phoneNumber.isNotBlank() || phoneNumber.isNotEmpty() &&
                smsMessage.isNotBlank() || smsMessage.isNotEmpty()
            ) {
                smsViewmodel.sendSMS(phoneNumber, smsMessage)
            }
        }) {
            Text(text = "send Message")
        }

    }

}