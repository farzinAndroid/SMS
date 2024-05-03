package com.farzin.sms.data.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import com.farzin.sms.data.notification.NotificationService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SMSReceiver : BroadcastReceiver() {

    @Inject
    lateinit var notificationService: NotificationService

    // show a notif when
    // the broadcast receives an action
    // like SMS_RECEIVED_ACTION
    // Use Broadcast receiver to listen to incoming
    // SMS
    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION){
            Log.e("TAG","${intent.action}")

            val msgFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            msgFromIntent.forEachIndexed { index, smsMessage ->
                Log.e("TAG",smsMessage.displayMessageBody)
                notificationService.showNotification(
                    smsMessage.displayMessageBody,
                    smsMessage.displayOriginatingAddress
                )
            }

        }
    }
}