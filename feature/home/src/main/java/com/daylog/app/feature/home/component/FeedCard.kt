package com.daylog.app.feature.home.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
) {
    DayLogCard{
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            // 🔹 날짜 헤더
            Text(
                text = "${diary.date} 뭉치",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            // 🔹 감정
            Text(
                text = "${diary.mood.emoji} ${diary.mood.text}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            // 🔹 이미지
            diary.imageUri?.let { uri ->
                Log.e("gyeom",uri)
                AsyncImage(
                    model = uri,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(6.dp))
            }

            // 🔹 산책 / 간식 통계
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(text = "🐾 ${diary.walkCount}")
                Text(text = "🍖 ${diary.snackCount}")
            }

            Spacer(modifier = Modifier.height(6.dp))

            // 🔹 일기 내용
            Text(
                text = diary.content,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}