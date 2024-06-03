package com.example.botanify.presentation.screen.alarmnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationPenyiramanReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val plantName = intent.getStringExtra("PLANT_NAME") ?: ""
        val notificationService = PenyiramanNotificationService(context)
        notificationService.showNotification(plantName)
    }
}