package com.daylog.app.feature.setting.component


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.daylog.app.core.designsystem.theme.component.DayLogCard
import com.daylog.app.core.designsystem.R

@Composable
fun ProfileCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    nickName: String = "뭉치",
    profileUri:String? = null
) {
    DayLogCard(
        modifier = modifier
            .padding(top = 20.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (profileUri != null) {
                    Log.e("gyeom",profileUri)
                }
                // 프로필 이미지 자리
                AsyncImage(
                    model = profileUri ?: R.drawable.ic_profile,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "$nickName 🐶",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}