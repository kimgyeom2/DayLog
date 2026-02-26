package com.daylog.app.feature.home.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daylog.app.core.designsystem.theme.component.DayLogCard
import com.daylog.app.core.model.Diary

@Composable
fun DiaryFeedItem(
    diary: Diary,
    onEdit: (Diary) -> Unit,
    onDelete: (Diary) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    DayLogCard {

        Box {

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {

                IconButton(
                    onClick = { expanded = true }
                ) {
                    Icon(Icons.Default.MoreVert, null)
                }

                DropdownMenu(
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("수정", color = MaterialTheme.colorScheme.onSurface)},
                        onClick = {
                            expanded = false
                            onEdit(diary)
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("삭제", color = MaterialTheme.colorScheme.onSurface)},
                        onClick = {
                            expanded = false
                            onDelete(diary)
                        }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ){

                Text(
                    text = "${diary.date} 뭉치",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = "${diary.mood.emoji} ${diary.mood.text}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(Modifier.height(4.dp))

                diary.imageUri?.let { uri ->
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.height(6.dp))
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Text("🐾 ${diary.walkCount}")
                    Text("🍖 ${diary.snackCount}")
                }

                Spacer(Modifier.height(6.dp))

                Text(
                    text = diary.content,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}