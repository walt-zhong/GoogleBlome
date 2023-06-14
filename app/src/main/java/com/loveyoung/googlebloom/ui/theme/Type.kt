package com.loveyoung.googlebloom.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.loveyoung.googlebloom.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val nunitoSansFamily = FontFamily(
    Font(R.font.nunitosans_light, FontWeight.Light),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold),
    Font(R.font.nunitosans_bold, FontWeight.Bold)
)

val bloomTypoGraphy = Typography(
    h1 = TextStyle(
        fontSize = 18.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Bold
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Light
    ),
    body1 = TextStyle(
        fontSize = 14.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Light
    ),
    body2 = TextStyle(
        fontSize = 12.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Light
    ),
    button = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 1.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold,
        color = white
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold
    )
)