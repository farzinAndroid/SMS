package com.farzin.sms.repository

import android.telephony.SmsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SMSRepositoryImpl @Inject constructor(
    private val smsManager: SmsManager
) : SMSRepository {

    override suspend fun sendSMS(phoneNumber: String, textMsg: String) {
        // use the IO Dispathers to
        // not freeze the UI

        withContext(Dispatchers.IO){
            smsManager.sendTextMessage(phoneNumber,null,textMsg,null,null)
        }
    }

}