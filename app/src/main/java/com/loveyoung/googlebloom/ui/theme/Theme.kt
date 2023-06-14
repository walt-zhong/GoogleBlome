package com.loveyoung.googlebloom.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.loveyoung.googlebloom.R

private val BloomDarkColorPalette = darkColors(
    primary = white,
    secondary = green300,
    background = green900,
    surface = white150,
    onPrimary =  white850,
    onSecondary = green900,
    onBackground = pink900,
    onSurface = white850,
)

private val BloomLightColorPalette = lightColors(
    primary = pink900,
    secondary = pink900,
    background = pink100,
    surface = white850,
    onPrimary = pink100,
    onSecondary = pink100,
    onBackground = pink900,
    onSurface = white150
)

open class WelcomePageAssets(var background:Int,var illos:Int,var logo:Int)

//亮色主题资源
object LightWelcomeAssets : WelcomePageAssets(
    background = R.drawable.ic_light_welcome_bg,
    illos = R.drawable.ic_light_welcome_illos,
    logo = R.drawable.ic_light_logo
)

// 暗色主提资源

object DarkWelcomeAssets : WelcomePageAssets(
    background = R.drawable.ic_dark_welcome_bg,
    illos = R.drawable.ic_dark_welcome_illos,
    logo = R.drawable.ic_dark_logo
)

internal var LocalWelcomeAssets = staticCompositionLocalOf { LightWelcomeAssets as WelcomePageAssets }

val welcomeAssets
@Composable
@ReadOnlyComposable
get() = LocalWelcomeAssets.current

enum class BloomTheme{
    LIGHT,DARK
}

@Composable
fun GoogleBloomTheme(theme:BloomTheme = BloomTheme.LIGHT,content:@Composable ()->Unit){
    val welcomeAssets = if(theme == BloomTheme.DARK) DarkWelcomeAssets else LightWelcomeAssets
    CompositionLocalProvider(
        LocalWelcomeAssets provides welcomeAssets
    ) {
        MaterialTheme(colors = if (theme == BloomTheme.DARK)
            BloomDarkColorPalette else BloomLightColorPalette,
        typography = bloomTypoGraphy,
        shapes = shapes,
        content = content,
        )
    }
}
