package com.daylog.app.core.model

data class MonthStats(
    val moodCount: Map<Mood, Int>,
    val walkTotal: Int,
    val snackTotal: Int
)