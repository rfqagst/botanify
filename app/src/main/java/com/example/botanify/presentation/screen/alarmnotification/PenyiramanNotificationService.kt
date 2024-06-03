package com.example.botanify.presentation.screen.alarmnotification

import android.app.NotificationManager
import android.content.Context
import android.text.Html.fromHtml
import androidx.core.app.NotificationCompat
import com.example.botanify.R

class PenyiramanNotificationService(private val context: Context,) {

    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(plantName : String) {
        val notification = NotificationCompat.Builder(context, PENYIRAMAN_CHANNEL_ID)
            .setContentTitle("Penyiraman Tanaman")
            .setContentText(fromHtml("Saatnya penyiraman tanaman <b>$plantName</b>"))
            .setSmallIcon(R.drawable.ic_wateringcan)
            .build()

        notificationManager.notify(1, notification)
    }


    companion object {
        const val PENYIRAMAN_CHANNEL_ID = "penyiraman_channel"
    }
}