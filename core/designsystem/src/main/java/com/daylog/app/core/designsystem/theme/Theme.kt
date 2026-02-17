package com.daylog.app.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

private val DarkColorScheme = darkColorScheme(
    primary = DaylogColor.Primary,
    secondary =  DaylogColor.PrimaryDark,
    tertiary = DaylogColor.DarkGray,
    background = DaylogColor.White,
    surface = DaylogColor.PrimaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = DaylogColor.Primary,
    secondary =  DaylogColor.PrimaryDark,
    tertiary = DaylogColor.White,
    background = DaylogColor.White,
    surface = DaylogColor.White
)

val LocalDarkTheme = compositionLocalOf { true }


object DayLogTheme {
    val typography: DayLogTypography
        @Composable
        get() = LocalTypography.current

    val shape: KnightsShape
        @Composable
        get() = LocalShape.current
}

@Composable
fun DayLogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

