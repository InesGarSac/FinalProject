package com.keepcoding.finalproject.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val PrimaryColor = Color(0xFFFC236E)
val White = Color(0xFFFFFFFF)

sealed class ThemeColors (
    val background: Color,
    val secondary: Color,
    val surface: Color,
    val primary: Color,
    val primaryVariant: Color,
    val text: Color
){
    object Night : ThemeColors(
        background = Color(0xFF858585),
        secondary = Color(0xFF535353),
        surface = Color(0xFF535353),
        primary = Color(0xFFFFFFFF),
        primaryVariant = Color(0xFFFFFFFF),
        text = Color(0xFF000000)
    )

    object Day : ThemeColors (
        background = Color(0xFFFFFFFF),
        secondary = Color(0xFFFF0057),
        surface = Color(0xFFFFFFFF),
        primary = Color(0xFFFF0057),
        primaryVariant = Color(0xFF000000),
        text = Color(0xFF000000)
    )
}
