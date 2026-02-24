package com.daylog.app.feature.main

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.feature.setting.SettingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = Color.TRANSPARENT, // 라이트 모드
                darkScrim = Color.TRANSPARENT   // 다크 모드
            )
        )

        setContent {
            val settingViewModel: SettingViewModel = hiltViewModel()
            val isDarkTheme by settingViewModel.isDarkTheme.collectAsState()

            DayLogTheme(darkTheme = isDarkTheme){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(settingViewModel)
                }
            }
        }
    }

//    @SuppressLint("ViewModelConstructorInComposable")
//    @Preview(showBackground = true)
//    @Composable
//    fun PreviewMain() {
//        MainScreen(
//            SettingViewModel()
//        )
//    }
}