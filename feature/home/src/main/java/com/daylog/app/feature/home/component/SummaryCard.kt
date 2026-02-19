package com.daylog.app.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.core.designsystem.theme.component.DayLogCard
import com.daylog.app.core.model.TodayState

@Composable
fun SummaryCard(
    summary: TodayState,
    dogName: String = "뭉치"
) {
    DayLogCard(
        modifier = Modifier
            .padding(top = 20.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 프로필 이미지 자리
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(DaylogColor.LightGray)
                )

                Spacer(Modifier.width(12.dp))

                Text(
                    text = "$dogName 🐶",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(Modifier.height(16.dp))

            Text("오늘의 ${dogName}")

            Spacer(Modifier.height(8.dp))

            Text("${summary.mood.emoji} ${summary.mood.text}")
            Text("🐾 산책 ${summary.walkCount}번")
            Text("🍖 간식 ${summary.snackCount}개")
        }
    }
}
