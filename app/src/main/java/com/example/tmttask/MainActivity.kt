package com.example.tmttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tmttask.ui.theme.Activities.TestScreenActivity
import com.example.tmttask.ui.theme.Activities.WebViewActivity
import com.example.tmttask.ui.theme.TmtTaskTheme
import com.example.tmttask.ui.theme.ViewModel.AlarmHelper
import com.example.tmttask.ui.theme.ViewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TmtTaskTheme {
                // A surface container using the 'background' color from the theme
                val alarmHelper = AlarmHelper(LocalContext.current)
                val viewModel: MainViewModel = viewModel()

                val activityLaunch = viewModel.getActivityToLaucnh()



                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Button(onClick = {
                        alarmHelper.scheduleActivityLaunch(WebViewActivity::class.java, 9,0)
                    })
                    {
                    Text("WebViewActivity")
                }
                    Spacer(modifier = Modifier.height(15.dp))

                    Button(onClick =  {

                        alarmHelper.scheduleActivityLaunch(WebViewActivity::class.java, 12,0)

                    }) {
                        Text("WebViewActivity")
                    }
                }

                Column (

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ){

                    Button(onClick = {
                        alarmHelper.scheduleActivityLaunch(TestScreenActivity::class.java, 12,0)
                    })
                    {
                        Text("WebViewActivity")
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Button(onClick =  {

                        alarmHelper.scheduleActivityLaunch(TestScreenActivity::class.java, 9,0)

                    }) {
                        Text("TestScreen")
                    }
                }

                }
            }
        }
    }


@Preview(showBackground = true)



@Composable

fun DefaultPreview(){
    TmtTaskTheme {
        PreviewContent()
    }
}

@Composable
fun PreviewContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {}) {
            Text("WebViewActivity", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {}) {
            Text("TestScreenActivity", fontWeight = FontWeight.Bold)

        }
    }
}


