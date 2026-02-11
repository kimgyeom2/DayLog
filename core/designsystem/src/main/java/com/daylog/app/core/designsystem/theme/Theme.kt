package com.daylog.app.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.daylog.app.core.designsystem.R

private val DarkColorScheme = darkColorScheme(
    primary = Color.DarkGray,
    secondary =  Color.DarkGray,
    tertiary =Color.DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Color.DarkGray,
    secondary = Color.DarkGray,
    tertiary = Color.DarkGray,
    background = Color.DarkGray // 여기에 배경색 지정
)

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

