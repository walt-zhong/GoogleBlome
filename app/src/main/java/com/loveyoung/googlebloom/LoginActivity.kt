package com.loveyoung.googlebloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loveyoung.googlebloom.ui.LoginPage
import com.loveyoung.googlebloom.ui.WelcomePage
import com.loveyoung.googlebloom.ui.theme.BloomTheme
import com.loveyoung.googlebloom.ui.theme.GoogleBloomTheme

class LoginActivity : ComponentActivity() {
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
                LoginPage()
            }
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

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleBloomTheme {
        Greeting("Android")
    }
}