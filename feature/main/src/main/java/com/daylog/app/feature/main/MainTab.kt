package com.daylog.app.feature.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainTab(
    val title: String,
    val icon: ImageVector
) {
    HOME("홈", Icons.Default.Home),
    CALENDAR("캘린더", Icons.Default.DateRange),
    PROFILE("프로필", Icons.Default.Person),
}