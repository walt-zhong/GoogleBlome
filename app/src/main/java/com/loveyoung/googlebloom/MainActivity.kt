package com.loveyoung.googlebloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loveyoung.googlebloom.ui.WelcomePage
import com.loveyoung.googlebloom.ui.theme.BloomTheme
import com.loveyoung.googlebloom.ui.theme.GoogleBloomTheme
import com.loveyoung.googlebloom.ui.theme.green900

class MainActivity : ComponentActivity() {
    private lateinit var theme: BloomTheme
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.apply { hide() }
        setContent {
            theme = if(isSystemInDarkTheme()){
                BloomTheme.DARK
            }else {
                BloomTheme.LIGHT
            }

            GoogleBloomTheme(theme) {
                val color = MaterialTheme.colors.background
                TransparentSystemBars(color)

                WelcomePage()

            }
        }
    }

    @Composable
    fun TransparentSystemBars(color: Color) {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color,
                darkIcons = useDarkIcons,
                isNavigationBarContrastEnforced = false,
            )
        }
    }
}
