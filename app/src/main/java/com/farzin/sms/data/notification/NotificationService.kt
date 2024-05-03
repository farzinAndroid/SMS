package com.farzin.sms.data.notification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.farzin.sms.R
import com.farzin.sms.util.NotificationHelper.NOTIFICATION_CHANNEL_ID
import com.farzin.sms.util.NotificationHelper.NOTIFICATION_ID
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManager: NotificationManager,
) {
    fun showNotification(text: String,sender:String) {
        val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_sms_24)
            .setContentTitle("You have new message by $sender")
            .setContentText(text)
        notificationManager.notify(
            NOTIFICATION_ID,
            notification.build()
        )
    }
}