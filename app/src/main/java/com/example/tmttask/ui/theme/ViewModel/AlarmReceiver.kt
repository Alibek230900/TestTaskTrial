package com.example.tmttask.ui.theme.ViewModel

import android.content.Context
import android.content.Intent

class AlarmReceiver {

    fun onReceive(context: Context?, intent: Intent?){
        if (context != null && intent != null){
            val activityClassName = intent.getStringArrayExtra("activity_class")
            val activityClass = Class.forName(activityClassName.toString())

            val launchIntent = Intent(context, activityClass)
            launchIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(launchIntent)
        }
    }

}
