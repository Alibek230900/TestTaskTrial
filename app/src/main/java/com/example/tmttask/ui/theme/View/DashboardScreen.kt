package com.example.tmttask.ui.theme.View

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tmttask.ui.theme.Model.SplashScreens
import kotlinx.coroutines.delay

class DashboardScreen {

    @Composable

    fun SplashScreen(navController: NavController)  = Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()


    ){
        val scale = remember {
            Animatable(0.0f)
        }

        LaunchedEffect(key1 = true){
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(1000, easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
            )

            delay(1000)
            navController.navigate(SplashScreens.dashboard){
                popUpTo(SplashScreens.splash){
                    inclusive = true
                }
            }
        }
    }

}