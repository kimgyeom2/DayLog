package com.daylog.app.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.daylog.app.feature.calendar.CalendarScreen
import com.daylog.app.feature.home.HomeScreen
import com.daylog.app.feature.profile.ProfileScreen
import kotlinx.collections.immutable.toImmutableList

@Composable
fun MainScreen() {

    var currentTab by remember { mutableStateOf(MainTab.HOME) }

    val tabs = remember { MainTab.entries.toImmutableList() }

    Scaffold(
        bottomBar = {
            MainBottomBar(
                visible = true,
                tabs = tabs,
                currentTab = currentTab,
                onTabSelected = { tab -> currentTab = tab }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (currentTab) {
                MainTab.HOME -> HomeScreen()
                MainTab.CALENDAR -> CalendarScreen()
                MainTab.PROFILE -> ProfileScreen()
            }
        }
    }
}