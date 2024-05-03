package com.farzin.sms.ui.screens.main

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.sms.util.InputValidation.isInputValid
import com.farzin.sms.viewModel.SMSViewmodel

@Composable
fun MainScreen(smsViewmodel: SMSViewmodel = hiltViewModel()) {

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var smsMessage by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        InputPhoneSection(
            phoneNumber = phoneNumber,
            onValueChange = { newText ->
                if (newText.all { it.isDigit() } && newText.length <= 11) {
                    phoneNumber = newText
                }
            },
            modifier = Modifier.align(Alignment.TopCenter)
        )



        InputTextSection(
            smsMessage = smsMessage,
            onValueChange = {
                smsMessage = it
            },
            onSendClick = {
                if (phoneNumber.isInputValid() &&
                    smsMessage.isNotBlank() && smsMessage.isNotEmpty()
                ) {
                    smsViewmodel.sendSMS(phoneNumber, smsMessage)
                } else {
                    Toast.makeText(context, "Invalid input", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }

}