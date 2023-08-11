package com.example.tmttask.ui.theme.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tmttask.ui.theme.Activities.TestScreenActivity
import com.example.tmttask.ui.theme.Activities.WebViewActivity
import java.util.Calendar

class MainViewModel: ViewModel() {

    fun getActivityToLaucnh(): Class<*>{
        val currentTime = Calendar.getInstance()
        val hour = currentTime.get(Calendar.HOUR_OF_DAY)

        return if (hour in 9..11) {
            WebViewActivity::class.java
        } else if (hour == 12) {
            TestScreenActivity::class.java
        } else {
            TestScreenActivity::class.java
        }
    }
}