package com.keepcoding.finalproject.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColors(
    primary = ThemeColors.Night.primary,
    secondary = ThemeColors.Night.secondary,
    onPrimary = ThemeColors.Night.text,
    surface = ThemeColors.Night.surface,
    primaryVariant = ThemeColors.Night.primaryVariant,
    background = ThemeColors.Night.background
)

private val LightColorScheme = lightColors(
    primary = ThemeColors.Day.primary,
    secondary = ThemeColors.Day.secondary,
    onPrimary = ThemeColors.Day.text,
    surface = ThemeColors.Day.surface,
    primaryVariant = ThemeColors.Day.primaryVariant,
    background = ThemeColors.Day.background

)

@Composable
fun FinalProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}