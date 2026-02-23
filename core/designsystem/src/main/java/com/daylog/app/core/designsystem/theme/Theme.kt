package com.daylog.app.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = DaylogColor.PrimaryDark,
    secondary =  DaylogColor.Primary,
    tertiary = DaylogColor.White,
    background = DaylogColor.Black,
    surface = DaylogColor.PrimaryDark,
    onSurface = DaylogColor.White
)

private val LightColorScheme = lightColorScheme(
    primary = DaylogColor.Primary,
    secondary =  DaylogColor.PrimaryDark,
    tertiary = DaylogColor.White,
    background = DaylogColor.White,
    surface = DaylogColor.White,
    onSurface = DaylogColor.Black
)



object DayLogTheme {
    val typography: DayLogTypography
        @Composable
        get() = LocalTypography.current

    val shape: DayLogShape
        @Composable
        get() = LocalShape.current
}

@Composable
fun DayLogTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

