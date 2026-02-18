package com.daylog.app.feature.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.feature.setting.component.LightDarkThemeCard

@Composable
fun SettingScreen(
    settingViewModel: SettingViewModel
) {
    val isDarkTheme by settingViewModel.isDarkTheme.collectAsState()

    SettingScreenContent(
        darkTheme = isDarkTheme,
        onChangeDarkTheme = { isDark ->
            settingViewModel.changeDarkTheme(isDark)
        }
    )
}

@Composable
private fun SettingScreenContent(
    darkTheme: Boolean,
    onChangeDarkTheme: (Boolean) -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(if (darkTheme) DaylogColor.Black else DaylogColor.White)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        LightDarkThemeCard(
            darkTheme = darkTheme,
            onChangeDarkTheme = onChangeDarkTheme,
        )
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun SettingScreenPreview() {
    DayLogTheme(false) {
        SettingScreen(
            SettingViewModel()
        )
    }
}