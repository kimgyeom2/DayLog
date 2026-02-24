package com.daylog.app.feature.setting.component

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daylog.app.core.designsystem.theme.DayLogTheme
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.core.designsystem.theme.component.DayLogCard
import com.daylog.app.feature.profile.R

@Composable
fun ProfileEditDialog(
    onDismiss: () -> Unit,
    onSave: (String, String?) -> Unit
) {

    var nickname by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker =
        rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) {
            imageUri = it
        }

    AlertDialog(

        onDismissRequest = onDismiss,
        containerColor = DaylogColor.White,

        confirmButton = {

            TextButton(
                onClick = {
                    onSave(
                        nickname,
                        imageUri?.toString()
                    )
                }
            ) {
                Text("저장", color = MaterialTheme.colorScheme.onSurface)
            }
        },

        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("취소", color = MaterialTheme.colorScheme.onSurface)
            }
        },

        text = {

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                // 프로필사진
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .background(DaylogColor.LightGray)
                        .clickable {
                            imagePicker.launch("image/*")
                        },
                    contentAlignment = Alignment.Center
                ) {

                    if (imageUri != null) {

                        AsyncImage(
                            model = imageUri,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    } else {

                        Text("📷")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 닉네임

                OutlinedTextField(
                    value = nickname,
                    onValueChange = {
                        nickname = it
                    },
                    label = {
                        Text("닉네임")
                    }
                )

            }
        }
    )
}