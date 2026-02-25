package com.daylog.app.feature.calendar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.daylog.app.core.designsystem.theme.component.DayLogCard
import com.daylog.app.core.model.MonthStats
import com.daylog.app.core.model.Mood
import java.time.LocalDate
import java.time.YearMonth
import kotlin.math.ceil

@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = hiltViewModel()
) {

    val month by viewModel.month.collectAsState()
    val moodMap by viewModel.moodMap.collectAsState()
    val stats by viewModel.monthStats.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        MonthHeader(
            month = month,
            onPrev = { viewModel.prevMonth() },
            onNext = { viewModel.nextMonth() }
        )

        Spacer(Modifier.height(16.dp))

        CalendarGrid(
            month = month,
            moodMap = moodMap,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 250.dp)
        )

        Spacer(Modifier.height(12.dp))

        stats?.let {
            MonthStatsCard(it)
        }
    }
}

@Composable
fun MonthHeader(
    month: YearMonth,
    onPrev: () -> Unit,
    onNext: () -> Unit
) {

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = onPrev) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Text(
            text = "${month.year}년 ${month.monthValue}월",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        IconButton(onClick = onNext) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun CalendarGrid(
    month: YearMonth,
    moodMap: Map<LocalDate, Mood>,
    modifier: Modifier = Modifier
) {

    val firstDay = month.atDay(1)
    val lastDay = month.atEndOfMonth()

    val startOffset = firstDay.dayOfWeek.value % 7
    val totalDays = lastDay.dayOfMonth

    val totalCells = startOffset + totalDays
    val rows = ceil(totalCells / 7f).toInt()

    Column(modifier) {

        // 요일
        Row(Modifier.fillMaxWidth()) {

            listOf("일", "월", "화", "수", "목", "금", "토").forEach {

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(it, color = MaterialTheme.colorScheme.onSurface)
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        var day = 1

        repeat(rows) { row ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                repeat(7) { index ->

                    val cellIndex = row * 7 + index

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(
                                width = 0.5.dp,
                                color = MaterialTheme.colorScheme.outline
                            )
                            .padding(top = 2.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {

                        if (cellIndex >= startOffset && day <= totalDays) {

                            val date = month.atDay(day)
                            val mood = moodMap[date]

                            val today = LocalDate.now()

                            val isToday = date == today

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    day.toString(),
                                    fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                mood?.let {
                                    Text(it.emoji)
                                }
                            }

                            day++
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MonthStatsCard(
    stats: MonthStats
) {

    DayLogCard {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "이달의 기록",
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("🐾 산책 ${stats.walkTotal}회")
                Spacer(Modifier.width(8.dp))
                Text("🍖 간식 ${stats.snackTotal}개")
            }

            Spacer(Modifier.height(2.dp))

            Text("감정 통계")

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Mood.entries.forEach { mood ->

                    val count = stats.moodCount[mood] ?: 0

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(mood.emoji)
                        Text("$count")
                    }
                }
            }
        }
    }
}