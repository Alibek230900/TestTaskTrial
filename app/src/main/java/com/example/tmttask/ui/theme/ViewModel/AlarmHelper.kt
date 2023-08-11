package com.example.tmttask.ui.theme.ViewModel

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar

class AlarmHelper (private val context: Context) {


    fun scheduleActivityLaunch(activityClass: Class<*>, hour:Int, minute:Int) {

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, AlarmReceiver::class.java)

        val request_code = 0
        val flags = PendingIntent.FLAG_UPDATE_CURRENT

        val pendingIntentChecker = PendingIntent.getActivity(context,request_code, intent,flags or PendingIntent.FLAG_IMMUTABLE)

        intent.putExtra("activity_class", activityClass.name)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }
}