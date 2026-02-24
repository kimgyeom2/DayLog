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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daylog.app.core.designsystem.R
import com.daylog.app.core.designsystem.theme.DaylogColor
import com.daylog.app.core.designsystem.theme.component.TodayCard
import com.daylog.app.core.model.TodayState

@Composable
fun SummaryCard(
    modifier: Modifier = Modifier,
    todayState: TodayState,
    nickName: String = "뭉치",
    profileUri : String?
) {
    TodayCard(
        modifier = modifier
            .padding(horizontal = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = profileUri ?: R.drawable.foot_print,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "오늘의 $nickName 🐶",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(Modifier.height(6.dp))

            Text("${todayState.mood.emoji} ${todayState.mood.text}")
            Text("🐾 산책 ${todayState.walkCount}번")
            Text("🍖 간식 ${todayState.snackCount}개")
        }
    }
}
