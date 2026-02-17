package com.daylog.app.feature.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.feature.setting.component.LightDarkThemeCard

@Composable
fun SettingScreen(
//    settingViewModel: SettingViewModel = hiltViewModel(),
) {
    val lifecycleOwner = LocalLifecycleOwner.current
//    LaunchedEffect(settingViewModel, lifecycleOwner) {
//        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//            settingViewModel.loadAction().launchIn(this)
//        }
//    }
    SettingScreen(
        onChangeDarkTheme = {
//            settingViewModel.send(SettingAction.ChangeDarkTheme(it))
        },
    )
}

@Composable
private fun SettingScreen(
    onChangeDarkTheme: (Boolean) -> Unit,
) {
    Column(
        Modifier
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        LightDarkThemeCard(
            onChangeDarkTheme = onChangeDarkTheme,
        )
    }
}

@Preview
@Composable
private fun SettingScreenPreview() {
    DayLogTheme {
        SettingScreen(
            onChangeDarkTheme = {},
        )
    }
}