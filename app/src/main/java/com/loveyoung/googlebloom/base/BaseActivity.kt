package com.loveyoung.googlebloom.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loveyoung.googlebloom.ui.theme.BloomTheme
import com.loveyoung.googlebloom.ui.theme.GoogleBloomTheme

abstract class BaseActivity : ComponentActivity() {
    private lateinit var theme: BloomTheme
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.apply { hide() }
        setContent {
            theme = if (isSystemInDarkTheme()) {
                BloomTheme.DARK
            } else {
                BloomTheme.LIGHT
            }

            GoogleBloomTheme(theme) {
                val color = MaterialTheme.colors.background
                TransparentSystemBars(color)
                LoadUI()
            }
        }
    }

    @Composable
    abstract fun LoadUI()
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