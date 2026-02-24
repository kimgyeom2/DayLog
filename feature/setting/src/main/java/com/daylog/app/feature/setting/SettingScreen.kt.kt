package com.daylog.app.feature.setting

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.feature.setting.component.LightDarkThemeCard
import com.daylog.app.feature.setting.component.ProfileCard
import com.daylog.app.feature.setting.component.ProfileEditDialog
import java.io.File
import androidx.core.net.toUri

@Composable
fun SettingScreen(
    settingViewModel: SettingViewModel
) {
    val isDarkTheme by settingViewModel.isDarkTheme.collectAsState()

    SettingScreenContent(
        settingViewModel = settingViewModel,
        darkTheme = isDarkTheme,
        onChangeDarkTheme = { isDark ->
            settingViewModel.changeDarkTheme(isDark)
        }
    )
}

@Composable
private fun SettingScreenContent(
    settingViewModel: SettingViewModel,
    darkTheme: Boolean,
    onChangeDarkTheme: (Boolean) -> Unit,
) {
    var showProfileDialog by remember { mutableStateOf(false) }
    val nickName by settingViewModel.nickName.collectAsState()
    val profileUri by settingViewModel.profileUri.collectAsState()
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(if (darkTheme) DaylogColor.Black else DaylogColor.White)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        ProfileCard(
            onClick = { showProfileDialog = true },
            nickName = nickName,
            profileUri = profileUri
        )

        LightDarkThemeCard(
            darkTheme = darkTheme,
            onChangeDarkTheme = onChangeDarkTheme,
        )
    }

    if (showProfileDialog) {
        ProfileEditDialog(
            onDismiss = { showProfileDialog = false },
            onSave = { name, uri ->

                if (name.isBlank()){
                    Toast.makeText(context, "닉네임을 입력하세요", Toast.LENGTH_SHORT).show()
                    return@ProfileEditDialog
                }

                settingViewModel.saveNickName(name)
                uri?.let {

                    val path = copyImageToInternalStorage(
                        context,
                        it.toUri()
                    )

                    settingViewModel.saveProfileUri(path)
                }

                showProfileDialog = false
            }
        )
    }
}

fun copyImageToInternalStorage(
    context: Context,
    uri: Uri
): String {

    val fileName = "profile_image.jpg"
    val file = File(context.filesDir, fileName)

    context.contentResolver.openInputStream(uri)?.use { input ->
        file.outputStream().use { output ->
            input.copyTo(output)
        }
    }

    return file.absolutePath
}

//@SuppressLint("ViewModelConstructorInComposable")
//@Preview
//@Composable
//private fun SettingScreenPreview() {
//    DayLogTheme(false) {
//        SettingScreen(
//            SettingViewModel()
//        )
//    }
//}