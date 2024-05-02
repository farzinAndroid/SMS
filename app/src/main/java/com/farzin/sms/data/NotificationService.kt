package com.farzin.sms.data

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.farzin.sms.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManager: NotificationManager,
) {
    companion object {
        const val NOTIFICATION_CHANNEL_ID = "NOTIFICATION_CHANNEL_ID"
        const val NOTIFICATION_ID = 1
    }

    fun showNotification(text: String) {
        val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_sms_24)
            .setContentTitle("You have new message")
            .setGroup("my group")
            .setPriority(NotificationManager.IMPORTANCE_MAX)
            .setContentText(text)
            .setOngoing(true)
        notificationManager.notify(
            NOTIFICATION_ID,
            notification.build()
        )
    }
}