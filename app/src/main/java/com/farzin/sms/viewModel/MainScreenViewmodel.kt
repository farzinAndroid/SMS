package com.farzin.sms.viewModel

import android.telephony.SmsManager
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewmodel @Inject constructor(
    private val smsManager: SmsManager
) : ViewModel() {


    fun sendSMS(phoneNumber:String,textMsg:String){
        smsManager.sendTextMessage(phoneNumber,null,textMsg,null,null)
    }

}