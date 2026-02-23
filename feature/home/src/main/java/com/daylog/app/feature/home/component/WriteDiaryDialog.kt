package com.daylog.app.feature.home.component

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.core.model.Diary
import com.daylog.app.core.model.Mood
import java.time.LocalDate

@Composable
fun WriteDiaryDialog(
    onDismiss: () -> Unit,
    onSave: (Diary) -> Unit,
    noContent: ()-> Unit
) {
    var content by remember { mutableStateOf("") }
    var walkCount by remember { mutableStateOf("") }
    var snackCount by remember { mutableStateOf("") }
    var selectedMood by remember { mutableStateOf(Mood.HAPPY) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            Log.e("gyeom",uri.toString())
            imageUri = uri
        }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = DaylogColor.White,
        confirmButton = {
            TextButton(
                onClick = {
                    if (content.isBlank()){
                        noContent()
                        return@TextButton
                    }
                    val diary = Diary(
                        date = LocalDate.now().toString(),
                        mood = selectedMood,
                        content = content,
                        walkCount = walkCount.toIntOrNull() ?: 0,
                        snackCount = snackCount.toIntOrNull() ?: 0,
                        imageUri = imageUri?.toString()
                    )
                    onSave(diary)
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
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .background(DaylogColor.LightGray)
                        .clickable {
                            imagePickerLauncher.launch("image/*")
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
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }

                // 🐾 기분 선택
                MoodSelector(
                    selectedMood = selectedMood,
                    onMoodSelected = { selectedMood = it }
                )

                // ✍ 일기 내용
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("오늘의 이야기") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )

                // 📊 산책 / 간식
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = walkCount,
                        onValueChange = { walkCount = it },
                        label = { Text("🐾 산책") },
                        modifier = Modifier.weight(1f),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = snackCount,
                        onValueChange = { snackCount = it },
                        label = { Text("🍖 간식") },
                        modifier = Modifier.weight(1f),
                        singleLine = true
                    )
                }
            }
        }
    )
}

@Composable
fun MoodSelector(
    selectedMood: Mood,
    onMoodSelected: (Mood) -> Unit
) {
    val moods = Mood.entries

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            moods.take(3).forEach { mood ->
                MoodChip(
                    mood = mood,
                    selected = mood == selectedMood,
                    onClick = { onMoodSelected(mood) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            moods.drop(3).forEach { mood ->
                MoodChip(
                    mood = mood,
                    selected = mood == selectedMood,
                    onClick = { onMoodSelected(mood) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun MoodChip(
    mood: Mood,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        color = if (selected)
            MaterialTheme.colorScheme.primary
        else
            DaylogColor.LightGray,
        tonalElevation = 6.dp,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            Text(
                text = mood.emoji,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = mood.text,
                style = MaterialTheme.typography.labelMedium,
                color = if (selected)
                    MaterialTheme.colorScheme.onPrimary
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}