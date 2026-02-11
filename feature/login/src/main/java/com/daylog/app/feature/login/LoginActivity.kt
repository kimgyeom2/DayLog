package com.daylog.app.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.daylog.app.core.common.BaseActivity
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.core.navigation.Navigator
import com.daylog.app.feature.login.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity() { // BaseActivity 대신 사용 권장

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Edge-to-edge 설정 (선택사항)
        enableEdgeToEdge()

        setContent {
            // 프로젝트의 Theme 적용 (예: MyTheme)
            DayLogTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen(
                        viewModel = viewModel,
                        onJoinClick = { id, pw -> viewModel.signUp(id, pw) },
                        onLoginClick = { id, pw -> viewModel.login(id, pw) }
                    )
                }
            }
        }
    }
}