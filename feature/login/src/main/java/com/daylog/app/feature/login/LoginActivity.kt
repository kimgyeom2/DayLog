package com.daylog.app.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.core.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DayLogTheme(false) {
                val context = LocalContext.current

                LaunchedEffect(Unit) {
                    viewModel.toastMessage.collect { msg ->
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    }
                }

                LaunchedEffect(Unit) {
                    viewModel.navigateToMain.collect {
                        navigator.navigateToMain()
                        finish()
                    }
                }

                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen(
                        onJoinClick = { id, pw -> viewModel.signUp(id, pw) },
                        onLoginClick = { id, pw -> viewModel.login(id, pw) }
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun LoginScreenPreview() {
        LoginScreen(
            onJoinClick = { _, _ -> },
            onLoginClick = { _, _ -> }
        )
    }
}