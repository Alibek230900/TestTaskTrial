package com.example.tmttask.ui.theme.Activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tmttask.R
import com.example.tmttask.ui.theme.TmtTaskTheme
import com.example.tmttask.ui.theme.ViewModel.MainViewModel

class TestScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_screen)

        setContent {
            TmtTaskTheme {
                val viewModel: MainViewModel = viewModel()

                val activityToLaunch = viewModel.getActivityToLaucnh()

                if (activityToLaunch == TestScreenActivity::class.java){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        var displayText by remember { mutableStateOf("Press the button") }

                        Button(
                            onClick = {
                                displayText = "Hello"
                            }
                        ){
                            Text(displayText)
                        }
                    }
                }
            }
        }
    }
}